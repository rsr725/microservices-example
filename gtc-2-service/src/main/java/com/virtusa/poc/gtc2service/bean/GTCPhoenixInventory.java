package com.virtusa.poc.gtc2service.bean;

public class GTCPhoenixInventory {
	
	private long id;
	private String deviceId;
	private String headendId;
	private String emsHeadendPort;
	private String port;
	private String testType;
	private String vendor;
	private String emsId;
	private String jobType;
	private String serviceStatus;
	private String fqdnUrl;
	private String ein;
	private String status;
	private String requestFrom;
	
	public GTCPhoenixInventory() {
	}
	
	public GTCPhoenixInventory(long id, String deviceId, String headendId, String emsHeadendPort, String port,
			String testType, String vendor, String emsId, String jobType, String serviceStatus, String fqdnUrl,
			String ein, String status) {
		super();
		this.id = id;
		this.deviceId = deviceId;
		this.headendId = headendId;
		this.emsHeadendPort = emsHeadendPort;
		this.port = port;
		this.testType = testType;
		this.vendor = vendor;
		this.emsId = emsId;
		this.jobType = jobType;
		this.serviceStatus = serviceStatus;
		this.fqdnUrl = fqdnUrl;
		this.ein = ein;
		this.status = status;
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

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getEmsId() {
		return emsId;
	}

	public void setEmsId(String emsId) {
		this.emsId = emsId;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getFqdnUrl() {
		return fqdnUrl;
	}

	public void setFqdnUrl(String fqdnUrl) {
		this.fqdnUrl = fqdnUrl;
	}

	public String getEin() {
		return ein;
	}

	public void setEin(String ein) {
		this.ein = ein;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "GTCPhoenixInventory [id=" + id + ", deviceId=" + deviceId + ", headendId=" + headendId
				+ ", emsHeadendPort=" + emsHeadendPort + ", port=" + port + ", testType=" + testType + ", vendor="
				+ vendor + ", emsId=" + emsId + ", jobType=" + jobType + ", serviceStatus=" + serviceStatus
				+ ", fqdnUrl=" + fqdnUrl + ", ein=" + ein + ", status=" + status + ", requestFrom=" + requestFrom + "]";
	}
	

}
