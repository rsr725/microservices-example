package com.virtusa.poc.gtc2service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.virtusa.poc.gtc2service.bean.GTCPhoenixInventory;

@FeignClient(name="phoenix-inventory-service", url="http://localhost:8000")
//@RibbonClient(name="phoenix-inventory-service")
public interface PhoenixInventoryProxy {
	
	//@GetMapping("/phoenix-inventory-service/test")
	@GetMapping("/test")
	public String test();
	
	@PostMapping("/phoenix/get-ems-details")
	public GTCPhoenixInventory getEMSDetails(@RequestBody GTCPhoenixInventory phoenixInventory);
}
