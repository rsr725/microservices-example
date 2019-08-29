package com.virtusa.poc.gtc2service.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.poc.gtc2service.EMSProxy;
import com.virtusa.poc.gtc2service.GTCCommonConstant;
import com.virtusa.poc.gtc2service.PhoenixInventoryProxy;
import com.virtusa.poc.gtc2service.ServiceDownException;
import com.virtusa.poc.gtc2service.TaddsProxy;
import com.virtusa.poc.gtc2service.bean.GTCEMSToggle;
import com.virtusa.poc.gtc2service.bean.GTCPhoenixInventory;
import com.virtusa.poc.gtc2service.bean.GTCTaddsLog;

import feign.RetryableException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GTC2Controller {
	
	@Autowired
	PhoenixInventoryProxy phoenixInventoryProxy;
	
	@Autowired
	EMSProxy emsProxy;
	
	@Autowired
	TaddsProxy taddsProxy;
	
	@PostMapping("/gtc2/set-ems-toggle-status")
	public GTCEMSToggle setEMSToggleStatus(@RequestBody GTCPhoenixInventory gtcPhoenixInventory) {
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		GTCPhoenixInventory phoenixInventory = null;
		GTCEMSToggle updatedGTCEMSToggle = new GTCEMSToggle();
		try {
			phoenixInventory = phoenixInventoryProxy.getEMSDetails(gtcPhoenixInventory);
		} catch (RetryableException re) {
			throw new ServiceDownException(500, "Pheonix service is down!");
		} 
			GTCEMSToggle gtcemsToggle = emsProxy.getEMSToggleStatus(phoenixInventory);
			gtcemsToggle.setStatus(gtcPhoenixInventory.getStatus());
			gtcemsToggle.setModifiedTime(new Date());
			updatedGTCEMSToggle = emsProxy.setEMSToggleStatus(gtcemsToggle);
			updatedGTCEMSToggle.setFriendlyMsg(GTCCommonConstant.EMS_TOGGLE_CODE_AND_MSG.get(updatedGTCEMSToggle.getToggleCode()));
			GTCEMSToggle gtcemsToggleAfterUpdate = emsProxy.getEMSToggleStatus(phoenixInventory);
			if(gtcemsToggleAfterUpdate.getStatus().equalsIgnoreCase(gtcPhoenixInventory.getStatus())) {
				updatedGTCEMSToggle.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_PASS);
			} else { 
				updatedGTCEMSToggle.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_FAIL) ;
			}
			Timestamp endTime = new Timestamp(System.currentTimeMillis());
			GTCTaddsLog gtcTaddsLog = new GTCTaddsLog(gtcPhoenixInventory.getDeviceId(), 
					gtcPhoenixInventory.getHeadendId(), 
					gtcPhoenixInventory.getPort(), 
					gtcPhoenixInventory.getJobType(), 
					gtcPhoenixInventory.getTestType(), 
					gtcPhoenixInventory.getEin(), 
					updatedGTCEMSToggle.getEmsId(), 
					updatedGTCEMSToggle.getToggleCode(), 
					"", new Date(),
					updatedGTCEMSToggle.getModifiedTime(),
					updatedGTCEMSToggle.getStatus(),
					updatedGTCEMSToggle.getOutcomeStatus());
			gtcTaddsLog.setStartTime(startTime);
			gtcTaddsLog.setEndTime(endTime);
			gtcTaddsLog.setFaultLocation(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_PASS.equalsIgnoreCase(updatedGTCEMSToggle.getOutcomeStatus()) ? GTCCommonConstant.EMS_TOGGLE_FAULT_LOCATION_OK : GTCCommonConstant.EMS_TOGGLE_FAULT_LOCATION_DT);
			gtcTaddsLog.setEmsHeadendPort(phoenixInventory.getEmsHeadendPort());
			gtcTaddsLog.setRequestFrom(gtcPhoenixInventory.getRequestFrom());
			taddsProxy.storeTestResultLog(gtcTaddsLog);
		
		return updatedGTCEMSToggle;
	}
	
	@PostMapping("/gtc2/get-ems-toggle-status")
	public GTCEMSToggle getEMSToggleStatus(@RequestBody GTCPhoenixInventory gtcPhoenixInventory) {
		GTCPhoenixInventory phoenixInventory = phoenixInventoryProxy.getEMSDetails(gtcPhoenixInventory);
		GTCEMSToggle gtcemsToggle = emsProxy.getEMSToggleStatus(phoenixInventory);
		gtcemsToggle.setFriendlyMsg(GTCCommonConstant.EMS_TOGGLE_CODE_AND_MSG.get(gtcemsToggle.getToggleCode()));
		if(gtcemsToggle != null){
			gtcemsToggle.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_PASS);
			gtcemsToggle.setFriendlyMsg(GTCCommonConstant.EMS_TOGGLE_CODE_AND_MSG.get(gtcemsToggle.getToggleCode()));
		}
		return gtcemsToggle;
	}
	
	@PostMapping("/gtc2/get-log-by-deviceid")
	public List<GTCTaddsLog> getLogByDeviceId(@RequestBody GTCTaddsLog gtcTaddsLog) {
		return updateFriendlyMsgforToggleCode(taddsProxy.findByDeviceId(gtcTaddsLog));
	}
	
	@PostMapping("/gtc2/get-log-by-deviceid-cr-md")
	public List<GTCTaddsLog> getLogByDeviceIdCrTimeMdTime(@RequestBody GTCTaddsLog gtcTaddsLog) {
		return updateFriendlyMsgforToggleCode(taddsProxy.findByDeviceIdCreatedTimeModifiedTime(gtcTaddsLog));
	}
	
	@PostMapping("/gtc2/get-log-by-cr-md")
	public List<GTCTaddsLog> getLogByCrTimeMdTime(@RequestBody GTCTaddsLog gtcTaddsLog) {
		return updateFriendlyMsgforToggleCode(taddsProxy.findByCreatedTimeModifiedTime(gtcTaddsLog));
	}
	
	private static List<GTCTaddsLog> updateFriendlyMsgforToggleCode(List<GTCTaddsLog> list) {
		list.stream().forEach(l->l.setFriendlyMsg(GTCCommonConstant.EMS_TOGGLE_CODE_AND_MSG.get(l.getToggleCode())));
		return list;
	}
}
