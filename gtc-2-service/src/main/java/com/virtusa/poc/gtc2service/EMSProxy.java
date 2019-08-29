package com.virtusa.poc.gtc2service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.virtusa.poc.gtc2service.bean.GTCEMSToggle;
import com.virtusa.poc.gtc2service.bean.GTCPhoenixInventory;

@FeignClient(name="ems-service", url="http://localhost:8001")
//@RibbonClient(name="ems-service")
public interface EMSProxy {
	@GetMapping("/test")
	public String test();
	
	@PostMapping("/ems/get-toggle-status")
	public GTCEMSToggle getEMSToggleStatus(@RequestBody GTCPhoenixInventory gtcPhoenixInventory);
	
	@PostMapping("/ems/set-toggle-status")
	public GTCEMSToggle setEMSToggleStatus(@RequestBody GTCEMSToggle emsToggle);
}
