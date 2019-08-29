package com.virtusa.poc.gtc2service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.poc.gtc2service.EMSProxy;
import com.virtusa.poc.gtc2service.PhoenixInventoryProxy;
import com.virtusa.poc.gtc2service.TaddsProxy;

@RestController
public class TestController {
	
	@Autowired
	EMSProxy emsProxy;
	
	@Autowired
	PhoenixInventoryProxy phoenixInventoryProxy;
	
	@Autowired
	TaddsProxy taddsProxy;
	
	@GetMapping("/gtc2-ems/test")
	public String  test() {
		return emsProxy.test();
	}
	
	//@GetMapping("/phoenix-inventory-service/test")
	@GetMapping("/gtc2-phoenix/test")
	public String  testPhoenix() {
		return phoenixInventoryProxy.test();
	}
	
	@GetMapping("/gtc2-tadds/test")
	public String  testTadds() {
		return taddsProxy.test();
	}
	
	@GetMapping("/test")
	public String  testGTC2() {
		return "GTC-2 service in running...";
	}
}
