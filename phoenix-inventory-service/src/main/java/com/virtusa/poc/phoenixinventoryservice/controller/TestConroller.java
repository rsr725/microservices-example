package com.virtusa.poc.phoenixinventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConroller {
	
	@GetMapping("/test")
	public String test() {
		return "phoenix-inventory-service is running...";
	}
}
