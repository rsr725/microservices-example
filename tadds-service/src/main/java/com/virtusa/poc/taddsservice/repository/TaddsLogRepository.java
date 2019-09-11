package com.virtusa.poc.taddsservice.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.virtusa.poc.taddsservice.bean.TaddsLog;

@Repository
public interface TaddsLogRepository extends JpaRepository<TaddsLog, Long> {
	@Query("select t from TaddsLog t where t.deviceId = :deviceId and t.testType = :testType")
	Optional<List<TaddsLog>> findByDeviceId(@Param("deviceId") String deviceId, @Param("testType") String testType);
	
	@Query("select t from TaddsLog t where t.deviceId = :deviceId and t.createdTime >= :createdTime and t.modifiedTime <= :modifiedTime and t.testType = :testType")
	Optional<List<TaddsLog>> findByDeviceIdAndCreatedTimeAndModifiedTimeAndTestType(@Param("deviceId") String deviceId, @Param("createdTime")  Date createdTime, @Param("modifiedTime") Date modifiedTime, @Param("testType") String testType);
	
	@Query("select t from TaddsLog t where t.createdTime >= :createdTime and t.modifiedTime <= :modifiedTime and t.testType = :testType")
	Optional<List<TaddsLog>> findByCreatedTimeAndModifiedTimeAndTestType(@Param("createdTime") Date createdTime, @Param("modifiedTime") Date modifiedTime, @Param("testType") String testType);
}
