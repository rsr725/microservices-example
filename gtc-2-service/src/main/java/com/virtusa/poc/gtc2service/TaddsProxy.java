package com.virtusa.poc.gtc2service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.virtusa.poc.gtc2service.bean.GTCTaddsLog;

@FeignClient(name="tadds-service", url="http://localhost:8100")
//@RibbonClient(name="phoenix-inventory-service")
public interface TaddsProxy {
	
	@GetMapping("/test")
	public String test();
	
	@PostMapping("/tadds/logs/save")
	public ResponseEntity<Object> storeTestResultLog(@RequestBody GTCTaddsLog gtcTaddsLog);
	
	@PostMapping("/tadds/logs/get-by-deviceid")
	public List<GTCTaddsLog> findByDeviceId(@RequestBody GTCTaddsLog gtcTaddsLog);
	
	@PostMapping("/tadds/logs/get-by-deviceid-cr-md")
	public List<GTCTaddsLog> findByDeviceIdAndCreatedTimeAndModifiedTimeAndTestType(@RequestBody GTCTaddsLog gtcTaddsLog);
	
	@PostMapping("/tadds/logs/get-by-cr-md")
	public List<GTCTaddsLog> findByCreatedTimeAndModifiedTimeAndTestType(@RequestBody GTCTaddsLog gtcTaddsLog);
}
