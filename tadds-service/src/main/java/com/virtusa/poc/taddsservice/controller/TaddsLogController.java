package com.virtusa.poc.taddsservice.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<TaddsLog> findByDeviceId(@RequestBody TaddsLog taddsLog) {
		return taddsLogRepository.findByDeviceId(taddsLog.getDeviceId(), taddsLog.getTestType());
	}
	
	@PostMapping("/tadds/logs/get-by-deviceid-cr-md")
	public List<TaddsLog> findByDeviceIdCreatedTimeModifiedTime(@RequestBody TaddsLog taddsLog) {
		return taddsLogRepository.findByDeviceIdAndCreatedTimeAndModifiedTimeAndTestType(taddsLog.getDeviceId(), taddsLog.getCreatedTime(), taddsLog.getModifiedTime(), taddsLog.getTestType());
	}
	
	@PostMapping("/tadds/logs/get-by-cr-md")
	public List<TaddsLog> findByCreatedTimeModifiedTime(@RequestBody TaddsLog taddsLog) {
		return taddsLogRepository.findByCreatedTimeAndModifiedTimeAndTestType(taddsLog.getCreatedTime(), taddsLog.getModifiedTime(), taddsLog.getTestType());
	}
	
	@PostMapping("/tadds/logs/save")
	public ResponseEntity<Object> save(@RequestBody TaddsLog taddsLog) {
		TaddsLog log = taddsLogRepository.save(taddsLog);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(log.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
