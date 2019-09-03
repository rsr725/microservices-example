package com.virtusa.poc.taddsservice.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TaddsLog {
	
	@Id @GeneratedValue
	private long id;
	private String deviceId;
	private String headendId;
	private String port;
	private String emsHeadendPort;
	private String jobType;
	private String testType;
	private String ein;
	private String emsCode;
	private String toggleCode;
	private String testId;
	@Temporal(TemporalType.DATE)
	private Date createdTime;
	@Temporal(TemporalType.DATE)
	private Date modifiedTime;
	private Timestamp startTime;
	private Timestamp endTime;
	private String operation;
	private String outcome;
	private String faultLocation;
	private String requestFrom;
	
	public TaddsLog() {
		super();
	}

	
	public TaddsLog(long id, String deviceId, String headendId, String port, String emsHeadendPort, String jobType,
			String testType, String ein, String emsCode, String toggleCode, String testId, Date createdTime,
			Date modifiedTime, Timestamp startTime, Timestamp endTime, String operation, String outcome,
			String faultLocation) {
		super();
		this.id = id;
		this.deviceId = deviceId;
		this.headendId = headendId;
		this.port = port;
		this.emsHeadendPort = emsHeadendPort;
		this.jobType = jobType;
		this.testType = testType;
		this.ein = ein;
		this.emsCode = emsCode;
		this.toggleCode = toggleCode;
		this.testId = testId;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.operation = operation;
		this.outcome = outcome;
		this.faultLocation = faultLocation;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getHeadendId() {
		return headendId;
	}

	public void setHeadendId(String headendId) {
		this.headendId = headendId;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getEin() {
		return ein;
	}

	public void setEin(String ein) {
		this.ein = ein;
	}

	public String getEmsCode() {
		return emsCode;
	}

	public void setEmsCode(String emsCode) {
		this.emsCode = emsCode;
	}

	public String getToggleCode() {
		return toggleCode;
	}

	public void setToggleCode(String toggleCode) {
		this.toggleCode = toggleCode;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getFaultLocation() {
		return faultLocation;
	}

	public void setFaultLocation(String faultLocation) {
		this.faultLocation = faultLocation;
	}


	public String getEmsHeadendPort() {
		return emsHeadendPort;
	}


	public void setEmsHeadendPort(String emsHeadendPort) {
		this.emsHeadendPort = emsHeadendPort;
	}
	
	public String getRequestFrom() {
		return requestFrom;
	}


	public void setRequestFrom(String requestFrom) {
		this.requestFrom = requestFrom;
	}


	@Override
	public String toString() {
		return "TaddsLog [id=" + id + ", deviceId=" + deviceId + ", headendId=" + headendId + ", port=" + port
				+ ", emsHeadendPort=" + emsHeadendPort + ", jobType=" + jobType + ", testType=" + testType + ", ein="
				+ ein + ", emsCode=" + emsCode + ", toggleCode=" + toggleCode + ", testId=" + testId + ", createdTime="
				+ createdTime + ", modifiedTime=" + modifiedTime + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", operation=" + operation + ", outcome=" + outcome + ", faultLocation=" + faultLocation
				+ ", requestFrom=" + requestFrom + "]";
	}
}
