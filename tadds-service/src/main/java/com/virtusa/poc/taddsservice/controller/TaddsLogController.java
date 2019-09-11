package com.virtusa.poc.taddsservice.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.virtusa.poc.taddsservice.bean.TaddsLog;
import com.virtusa.poc.taddsservice.repository.TaddsLogRepository;

@RestController
public class TaddsLogController {
	
	@Autowired
	TaddsLogRepository taddsLogRepository;
	
	@GetMapping("/tadds/logs/{id}")
	public TaddsLog findById(@PathVariable long id) {
		Optional<TaddsLog> log = taddsLogRepository.findById(id);
		return log.get();
	}
	
	@PostMapping("/tadds/logs/get-by-deviceid")
	public ResponseEntity<List<TaddsLog>> findByDeviceId(@RequestBody TaddsLog taddsLog) {
		Optional<List<TaddsLog>> log = null;
		if(taddsLog != null) {
			log = taddsLogRepository.findByDeviceId(taddsLog.getDeviceId(), taddsLog.getTestType());
		}
		ResponseEntity<List<TaddsLog>> entity = null;
		List<TaddsLog> logList = new ArrayList<TaddsLog>();
		if(!log.isPresent()) {
			entity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(logList);
		}else {
			entity = ResponseEntity.ok(log.get());
		}
		return entity; 
	}
	
	@PostMapping("/tadds/logs/get-by-deviceid-cr-md")
	public ResponseEntity<List<TaddsLog>> findByDeviceIdCreatedTimeModifiedTime(@RequestBody TaddsLog taddsLog) {
		Optional<List<TaddsLog>> log = null;
		if(taddsLog != null) {
			log = taddsLogRepository.findByDeviceIdAndCreatedTimeAndModifiedTimeAndTestType(taddsLog.getDeviceId(), taddsLog.getCreatedTime(), taddsLog.getModifiedTime(), taddsLog.getTestType());
		}
		ResponseEntity<List<TaddsLog>> entity = null;
		List<TaddsLog> logList = new ArrayList<TaddsLog>();
		if(!log.isPresent()) {
			entity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(logList);
		}else {
			entity = ResponseEntity.ok(log.get());
		}
		return entity; 
	}
	
	@PostMapping("/tadds/logs/get-by-cr-md")
	public ResponseEntity<List<TaddsLog>> findByCreatedTimeModifiedTime(@RequestBody TaddsLog taddsLog) {
		Optional<List<TaddsLog>> log = null;
		if(taddsLog != null) {
			log = taddsLogRepository.findByCreatedTimeAndModifiedTimeAndTestType(taddsLog.getCreatedTime(), taddsLog.getModifiedTime(), taddsLog.getTestType());
		}
		ResponseEntity<List<TaddsLog>> entity = null;
		List<TaddsLog> logList = new ArrayList<TaddsLog>();
		if(!log.isPresent()) {
			entity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(logList);
		}else {
			entity = ResponseEntity.ok(log.get());
		}
		return entity; 
	}
	
	@PostMapping("/tadds/logs/save")
	public ResponseEntity<Object> save(@RequestBody TaddsLog taddsLog) {
		TaddsLog log = taddsLogRepository.save(taddsLog);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(log.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
