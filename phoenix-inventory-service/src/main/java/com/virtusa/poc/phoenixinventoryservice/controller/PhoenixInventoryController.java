package com.virtusa.poc.phoenixinventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.poc.phoenixinventoryservice.bean.PhoenixInventory;
import com.virtusa.poc.phoenixinventoryservice.repository.PhoenixInventoryRepository;

@RestController
public class PhoenixInventoryController {

	@Autowired
	PhoenixInventoryRepository repository;
	
	@GetMapping("/phoenix/all")
	public List<PhoenixInventory> getEMSDetails() {
		return repository.findAll(); 
	}
	
	/*@PostMapping("/phoenix/post/one")
	public PhoenixInventory getEMSDetails(@RequestBody PhoenixInventory phoenixInventory) {
		return repository.findById(phoenixInventory.getId()).get(); 
	}*/
	
	@PostMapping("/phoenix/get-ems-details")
	public PhoenixInventory getEMSDetails(@RequestBody PhoenixInventory phoenixInventory) {
		PhoenixInventory findByDeviceIdAndHeadendIdAndHeadendPort = repository.findByDeviceIdAndHeadendIdAndPort(phoenixInventory.getDeviceId(), phoenixInventory.getHeadendId(), phoenixInventory.getPort());
		System.out.println(findByDeviceIdAndHeadendIdAndHeadendPort);
		return findByDeviceIdAndHeadendIdAndHeadendPort; 
	}
	
}
