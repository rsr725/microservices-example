package com.virtusa.poc.emsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.poc.emsservice.bean.EMSToggle;

@Repository
public interface EMSToggleRepository extends JpaRepository<EMSToggle, Long>{
	
	EMSToggle findByemsIdAndHeadendIdAndEmsHeadendPort(String emsId, String headendId, String emsHeadendPort);
}
