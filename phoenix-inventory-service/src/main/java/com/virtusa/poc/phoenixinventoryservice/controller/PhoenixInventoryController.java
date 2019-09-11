package com.virtusa.poc.phoenixinventoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<PhoenixInventory> getEMSDetails(@RequestBody PhoenixInventory phoenixInventory) {
		Optional<PhoenixInventory> findByDeviceIdAndHeadendIdAndHeadendPort = repository.findByDeviceIdAndHeadendIdAndPort(phoenixInventory.getDeviceId(), phoenixInventory.getHeadendId(), phoenixInventory.getPort());
		ResponseEntity<PhoenixInventory> entity = null;
		PhoenixInventory inventory = new PhoenixInventory();
		if(!findByDeviceIdAndHeadendIdAndHeadendPort.isPresent()) {
			entity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(inventory);
		}else {
			entity = ResponseEntity.ok(findByDeviceIdAndHeadendIdAndHeadendPort.get());
		}
		return entity;
	}
	
}
