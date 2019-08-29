package com.virtusa.poc.emsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.poc.emsservice.bean.EMSToggle;
import com.virtusa.poc.emsservice.bean.EMSToggleConstant;
import com.virtusa.poc.emsservice.repository.EMSToggleRepository;

@RestController
public class EMSToggleController {
	
	@Autowired
	EMSToggleRepository emsToggleRepository;
	
	@GetMapping("/ems/get-all")
	public List<EMSToggle> getAllToggleStatus() {
		List<EMSToggle> list = emsToggleRepository.findAll();
		
		return list; 
	}
	
	@PostMapping("/ems/get-toggle-status")
	public EMSToggle getEMSToggleStatus(@RequestBody EMSToggle emsToggle) {
		EMSToggle ems = new EMSToggle();
		if(emsToggle != null) {
			ems = emsToggleRepository.findByemsIdAndHeadendIdAndEmsHeadendPort(emsToggle.getEmsId(), emsToggle.getHeadendId(), emsToggle.getEmsHeadendPort());
		}
		return ems; 
	}
	
	@PostMapping("/ems/set-toggle-status")
	public EMSToggle setToggleStatus(@RequestBody EMSToggle emsToggle) {
		EMSToggle ems = new EMSToggle();
		if(emsToggle != null) { 
			emsToggle.setToggleCode(EMSToggleConstant.EMS_TOGGLE_STATUS.get(EMSToggleConstant.EMS_TOGGLE_STATUS_ON.equalsIgnoreCase(emsToggle.getStatus()) ? EMSToggleConstant.EMS_TOGGLE_STATUS_ON : EMSToggleConstant.EMS_TOGGLE_STATUS_OFF.equalsIgnoreCase(emsToggle.getStatus()) ? EMSToggleConstant.EMS_TOGGLE_STATUS_OFF : EMSToggleConstant.EMS_TOGGLE_STATUS_ON));
			ems = emsToggleRepository.save(emsToggle);
		}
		return ems; 
	}
}
