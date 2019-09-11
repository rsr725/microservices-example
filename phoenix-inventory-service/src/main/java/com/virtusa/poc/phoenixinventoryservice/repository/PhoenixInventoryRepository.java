package com.virtusa.poc.phoenixinventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.poc.phoenixinventoryservice.bean.PhoenixInventory;

@Repository
public interface PhoenixInventoryRepository extends JpaRepository<PhoenixInventory, Long> {
	
	Optional<PhoenixInventory> findByDeviceIdAndHeadendIdAndPort(String deviceId, String headendId, String port);
}
