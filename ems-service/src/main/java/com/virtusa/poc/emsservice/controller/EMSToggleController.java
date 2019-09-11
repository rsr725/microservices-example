package com.virtusa.poc.emsservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.poc.emsservice.bean.EMSToggle;
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
	public ResponseEntity<EMSToggle> getEMSToggleStatus(@RequestBody EMSToggle emsToggle) {
		Optional<EMSToggle> ems = null;
		if(emsToggle != null) {
			ems = emsToggleRepository.findByemsIdAndHeadendIdAndEmsHeadendPort(emsToggle.getEmsId(), emsToggle.getHeadendId(), emsToggle.getEmsHeadendPort());
		}
		ResponseEntity<EMSToggle> entity = null;
		EMSToggle emsToggleDt = new EMSToggle();
		if(!ems.isPresent()) {
			entity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(emsToggleDt);
		}else {
			entity = ResponseEntity.ok(ems.get());
		}
		return entity; 
	}
	
	@PostMapping("/ems/set-toggle-status")
	public ResponseEntity<EMSToggle> setToggleStatus(@RequestBody EMSToggle emsToggle) {
		EMSToggle ems = new EMSToggle();
		if(emsToggle != null) { 
			ems = emsToggleRepository.save(emsToggle);
		}
		return ResponseEntity.ok(ems);
	}
}
