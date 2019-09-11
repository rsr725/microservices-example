package com.virtusa.poc.gtc2service.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.poc.gtc2service.EMSProxy;
import com.virtusa.poc.gtc2service.GTCCommonConstant;
import com.virtusa.poc.gtc2service.PhoenixInventoryProxy;
import com.virtusa.poc.gtc2service.TaddsProxy;
import com.virtusa.poc.gtc2service.bean.GTCEMSToggle;
import com.virtusa.poc.gtc2service.bean.GTCPhoenixInventory;
import com.virtusa.poc.gtc2service.bean.GTCTaddsLog;

import feign.FeignException;

@CrossOrigin(origins = "*")
@RestController
public class GTC2Controller {
	
	@Autowired
	PhoenixInventoryProxy phoenixInventoryProxy;
	
	@Autowired
	EMSProxy emsProxy;
	
	@Autowired
	TaddsProxy taddsProxy;
	
	
	@PostMapping("/gtc2/set-ems-toggle-status")
	public GTCEMSToggle setEMSToggleStatus(@RequestBody GTCPhoenixInventory gtcPhoenixInventory){
		Timestamp startTime = new Timestamp(System.currentTimeMillis());
		GTCPhoenixInventory phoenixInventory = new GTCPhoenixInventory();
		GTCEMSToggle updatedGTCEMSToggle = new GTCEMSToggle();
		String existingStatus = "";
		
		try {
			phoenixInventory = phoenixInventoryProxy.getEMSDetails(gtcPhoenixInventory);
			updatedGTCEMSToggle = this.getEMSToggetStatus(phoenixInventory);
			if("success".equalsIgnoreCase(updatedGTCEMSToggle.getErrorCode())) {
				existingStatus = updatedGTCEMSToggle.getStatus(); 
				updatedGTCEMSToggle.setStatus(gtcPhoenixInventory.getStatus());
				updatedGTCEMSToggle.setModifiedTime(new Date());
				
				updatedGTCEMSToggle = this.setEMSToggleStatus(updatedGTCEMSToggle);
				
				if(updatedGTCEMSToggle.getStatus().equalsIgnoreCase(gtcPhoenixInventory.getStatus())) {
					updatedGTCEMSToggle.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_PASS);
					updatedGTCEMSToggle.setToggleCode(GTCCommonConstant.EMS_TOGGLE_STATUS.get(GTCCommonConstant.EMS_TOGGLE_STATUS_ON.equalsIgnoreCase(updatedGTCEMSToggle.getStatus()) ? GTCCommonConstant.EMS_TOGGLE_STATUS_ON : GTCCommonConstant.EMS_TOGGLE_STATUS_OFF.equalsIgnoreCase(updatedGTCEMSToggle.getStatus()) ? GTCCommonConstant.EMS_TOGGLE_STATUS_OFF : ""));
				} else {
					updatedGTCEMSToggle.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_FAIL);
					updatedGTCEMSToggle.setToggleCode(GTCCommonConstant.EMS_TOGGLE_STATUS.get(GTCCommonConstant.EMS_TOGGLE_STATUS_ON.equalsIgnoreCase(gtcPhoenixInventory.getStatus()) ? GTCCommonConstant.EMS_TOGGLE_STATUS_ON : GTCCommonConstant.EMS_TOGGLE_STATUS_OFF.equalsIgnoreCase(gtcPhoenixInventory.getStatus()) ? GTCCommonConstant.EMS_TOGGLE_STATUS_OFF : ""));
				}
				updatedGTCEMSToggle.setFriendlyMsg(GTCCommonConstant.EMS_TOGGLE_CODE_AND_MSG.get(updatedGTCEMSToggle.getToggleCode()));
			}
		} catch (FeignException re) {
			updatedGTCEMSToggle.setErrorCode("error");
			updatedGTCEMSToggle.setModifiedTime(new Date());
			updatedGTCEMSToggle.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_FAIL);
			if(re.status() == GTCCommonConstant.NOT_FOUND) {
				updatedGTCEMSToggle.setFriendlyMsg(GTCCommonConstant.PHOENIX_NOT_FOUND_FRIENDLY_MSG);
			}else {
				
				updatedGTCEMSToggle.setFriendlyMsg(GTCCommonConstant.PHOENIX_ERROR_FRIENDLY_MSG);
			}
			
		} finally {
			Timestamp endTime = new Timestamp(System.currentTimeMillis());
			GTCTaddsLog gtcTaddsLog = new GTCTaddsLog(gtcPhoenixInventory.getDeviceId(), 
					gtcPhoenixInventory.getHeadendId(), 
					gtcPhoenixInventory.getPort(), 
					gtcPhoenixInventory.getJobType(), 
					gtcPhoenixInventory.getTestType(), 
					gtcPhoenixInventory.getEin(), 
					updatedGTCEMSToggle.getEmsId(), 
					GTCCommonConstant.EMS_TOGGLE_STATUS.get(GTCCommonConstant.EMS_TOGGLE_STATUS_ON.equalsIgnoreCase(updatedGTCEMSToggle.getStatus()) ? GTCCommonConstant.EMS_TOGGLE_STATUS_ON : GTCCommonConstant.EMS_TOGGLE_STATUS_OFF.equalsIgnoreCase(updatedGTCEMSToggle.getStatus()) ? GTCCommonConstant.EMS_TOGGLE_STATUS_OFF : ""), 
					"", new Date(),
					updatedGTCEMSToggle.getModifiedTime(),
					updatedGTCEMSToggle.getStatus(),
					updatedGTCEMSToggle.getOutcomeStatus());
			gtcTaddsLog.setStartTime(startTime);
			gtcTaddsLog.setEndTime(endTime);
			gtcTaddsLog.setFaultLocation(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_PASS.equalsIgnoreCase(updatedGTCEMSToggle.getOutcomeStatus()) ? GTCCommonConstant.EMS_TOGGLE_FAULT_LOCATION_OK : GTCCommonConstant.EMS_TOGGLE_FAULT_LOCATION_DT);
			gtcTaddsLog.setEmsHeadendPort(phoenixInventory.getEmsHeadendPort());
			gtcTaddsLog.setRequestFrom(gtcPhoenixInventory.getRequestFrom());
			try {
				if("success".equalsIgnoreCase(updatedGTCEMSToggle.getErrorCode())) {
					taddsProxy.storeTestResultLog(gtcTaddsLog);
				}
			} catch (FeignException re) {
				updatedGTCEMSToggle.setFriendlyMsg(GTCCommonConstant.TADDS_ERROR_FRIENDLY_MSG);
				updatedGTCEMSToggle.setStatus(existingStatus);
				this.setEMSToggleStatus(updatedGTCEMSToggle);
			}
		} 
		return updatedGTCEMSToggle;
	}
	
	private GTCEMSToggle setEMSToggleStatus(GTCEMSToggle gtcemsToggle) {
		GTCEMSToggle emsToggleStatus = new GTCEMSToggle();
		try {
			emsToggleStatus = emsProxy.setEMSToggleStatus(gtcemsToggle);
			emsToggleStatus.setErrorCode("success");
		} catch (FeignException re) {
			emsToggleStatus.setErrorCode("error");
			emsToggleStatus.setModifiedTime(new Date());
			emsToggleStatus.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_FAIL);
			if(re.status() == GTCCommonConstant.NOT_FOUND) {
				emsToggleStatus.setFriendlyMsg(GTCCommonConstant.EMS_NOT_FOUND_FRIENDLY_MSG);
			}else {
				emsToggleStatus.setFriendlyMsg(GTCCommonConstant.EMS_ERROR_FRIENDLY_MSG);
			}
		}
		return emsToggleStatus;
	} 
	
	private GTCEMSToggle getEMSToggetStatus(GTCPhoenixInventory phoenixInventory) {
		GTCEMSToggle emsToggleStatus = new GTCEMSToggle();
		try {
			emsToggleStatus = emsProxy.getEMSToggleStatus(phoenixInventory);
			emsToggleStatus.setErrorCode("success");
		} catch (FeignException re) {
			emsToggleStatus.setErrorCode("error");
			emsToggleStatus.setModifiedTime(new Date());
			emsToggleStatus.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_FAIL);
			if(re.status() == GTCCommonConstant.NOT_FOUND) {
				emsToggleStatus.setFriendlyMsg(GTCCommonConstant.EMS_NOT_FOUND_FRIENDLY_MSG);
			}else {
				emsToggleStatus.setFriendlyMsg(GTCCommonConstant.EMS_ERROR_FRIENDLY_MSG);
			}
		}
		return emsToggleStatus;
	}
	
	@PostMapping("/gtc2/get-ems-toggle-status")
	public GTCEMSToggle getEMSToggleStatus(@RequestBody GTCPhoenixInventory gtcPhoenixInventory) {
		GTCPhoenixInventory phoenixInventory = new GTCPhoenixInventory();
		GTCEMSToggle gtcemsToggle = new GTCEMSToggle();
		try {
			phoenixInventory = phoenixInventoryProxy.getEMSDetails(gtcPhoenixInventory);
			gtcemsToggle = this.getEMSToggetStatus(phoenixInventory);
			if(gtcemsToggle != null && "success".equalsIgnoreCase(gtcemsToggle.getErrorCode())){
				gtcemsToggle.setToggleCode(GTCCommonConstant.EMS_TOGGLE_STATUS.get(GTCCommonConstant.EMS_TOGGLE_STATUS_ON.equalsIgnoreCase(gtcemsToggle.getStatus()) ? GTCCommonConstant.EMS_TOGGLE_STATUS_ON : GTCCommonConstant.EMS_TOGGLE_STATUS_OFF.equalsIgnoreCase(gtcemsToggle.getStatus()) ? GTCCommonConstant.EMS_TOGGLE_STATUS_OFF : ""));
				gtcemsToggle.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_PASS);
				gtcemsToggle.setFriendlyMsg(GTCCommonConstant.EMS_TOGGLE_CODE_AND_MSG.get(gtcemsToggle.getToggleCode()));
			}
		} catch (FeignException e) {
			gtcemsToggle.setErrorCode("error");
			gtcemsToggle.setModifiedTime(new Date());
			gtcemsToggle.setOutcomeStatus(GTCCommonConstant.EMS_TOGGLE_OUTCOME_STATUS_FAIL);
			if(e.status() == GTCCommonConstant.NOT_FOUND) {
				gtcemsToggle.setFriendlyMsg(GTCCommonConstant.PHOENIX_NOT_FOUND_FRIENDLY_MSG);
			}else {
				gtcemsToggle.setFriendlyMsg(GTCCommonConstant.PHOENIX_ERROR_FRIENDLY_MSG);
			}
		}
		return gtcemsToggle;
	}
	
	@PostMapping("/gtc2/get-log-by-deviceid")
	public List<GTCTaddsLog> getLogByDeviceId(@RequestBody GTCTaddsLog gtcTaddsLog) {
		List<GTCTaddsLog> findByDeviceId = new ArrayList<GTCTaddsLog>();
		try {
			findByDeviceId = taddsProxy.findByDeviceId(gtcTaddsLog);
			if(findByDeviceId.size()>0) {
				updateFriendlyMsgforToggleCode(findByDeviceId);
			}
			
		} catch (FeignException e) {
		 	GTCTaddsLog log = new GTCTaddsLog();
		 	if(e.status() == GTCCommonConstant.NOT_FOUND) {
		 		log.setFriendlyMsg(GTCCommonConstant.TADDS_NOT_FOUND_FRIENDLY_MSG);
			}else {
				log.setFriendlyMsg(GTCCommonConstant.TADDS_ERROR_FRIENDLY_MSG);
			}
			findByDeviceId.add(log);
		}
		return findByDeviceId;
	}
	
	@PostMapping("/gtc2/get-log-by-deviceid-cr-md")
	public List<GTCTaddsLog> getLogByDeviceIdCrTimeMdTime(@RequestBody GTCTaddsLog gtcTaddsLog) {
		List<GTCTaddsLog> findByDeviceId = new ArrayList<GTCTaddsLog>();
		try {
			findByDeviceId = taddsProxy.findByDeviceIdAndCreatedTimeAndModifiedTimeAndTestType(gtcTaddsLog);
			if(findByDeviceId.size()>0) {
				updateFriendlyMsgforToggleCode(findByDeviceId);
			}
			
		} catch (FeignException e) {
		 	GTCTaddsLog log = new GTCTaddsLog();
		 	if(e.status() == GTCCommonConstant.NOT_FOUND) {
		 		log.setFriendlyMsg(GTCCommonConstant.TADDS_NOT_FOUND_FRIENDLY_MSG);
			}else {
				log.setFriendlyMsg(GTCCommonConstant.TADDS_ERROR_FRIENDLY_MSG);
			}
			findByDeviceId.add(log);
		}
		return findByDeviceId;
	}
	
	@PostMapping("/gtc2/get-log-by-cr-md")
	public List<GTCTaddsLog> getLogByCrTimeMdTime(@RequestBody GTCTaddsLog gtcTaddsLog) {
		List<GTCTaddsLog> findByDeviceId = new ArrayList<GTCTaddsLog>();
		try {
			findByDeviceId = taddsProxy.findByCreatedTimeAndModifiedTimeAndTestType(gtcTaddsLog);
			if(findByDeviceId.size()>0) {
				updateFriendlyMsgforToggleCode(findByDeviceId);
			}
			
		} catch (FeignException e) {
		 	GTCTaddsLog log = new GTCTaddsLog();
		 	if(e.status() == GTCCommonConstant.NOT_FOUND) {
		 		log.setFriendlyMsg(GTCCommonConstant.TADDS_NOT_FOUND_FRIENDLY_MSG);
			}else {
				log.setFriendlyMsg(GTCCommonConstant.TADDS_ERROR_FRIENDLY_MSG);
			}
			findByDeviceId.add(log);
		}
		return findByDeviceId;
	}
	
	private static List<GTCTaddsLog> updateFriendlyMsgforToggleCode(List<GTCTaddsLog> list) {
		list.stream().forEach(l->l.setFriendlyMsg(GTCCommonConstant.EMS_TOGGLE_CODE_AND_MSG.get(l.getToggleCode())));
		return list;
	}
}
