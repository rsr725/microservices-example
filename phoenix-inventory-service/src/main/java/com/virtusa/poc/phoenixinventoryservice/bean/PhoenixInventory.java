/**
 * 
 */
package com.virtusa.poc.phoenixinventoryservice.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rrusia
 *
 */
@Entity
public class PhoenixInventory {
	
	@Id
	private long id;
	private String deviceId;
	private String headendId;
	private String port;
	private String emsHeadendPort;
	private String headendDetails;
	private String vendor;
	private String emsId;
	private String serviceStatus;
	private String fqdnUrl;
	private String emsType;
	/*@Transient
	private String jobType;*/
	
	/*@Transient
	private String ein;
	@Transient
	private String status;*/
	
	public PhoenixInventory() {
	}
	public PhoenixInventory(long id, String deviceId, String headendId, String port, String emsHeadendPort,
			String headendDetails, String vendor, String emsId, String serviceStatus, String fqdnUrl, String emsType) {
		super();
		this.id = id;
		this.deviceId = deviceId;
		this.headendId = headendId;
		this.port = port;
		this.emsHeadendPort = emsHeadendPort;
		this.headendDetails = headendDetails;
		this.vendor = vendor;
		this.emsId = emsId;
		this.serviceStatus = serviceStatus;
		this.fqdnUrl = fqdnUrl;
		this.emsType = emsType;
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
	public String getEmsHeadendPort() {
		return emsHeadendPort;
	}
	public void setEmsHeadendPort(String emsHeadendPort) {
		this.emsHeadendPort = emsHeadendPort;
	}
	public String getHeadendDetails() {
		return headendDetails;
	}
	public void setHeadendDetails(String headendDetails) {
		this.headendDetails = headendDetails;
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
	public String getEmsType() {
		return emsType;
	}
	public void setEmsType(String emsType) {
		this.emsType = emsType;
	}
	@Override
	public String toString() {
		return "PhoenixInventory [id=" + id + ", deviceId=" + deviceId + ", headendId=" + headendId + ", port=" + port
				+ ", emsHeadendPort=" + emsHeadendPort + ", headendDetails=" + headendDetails + ", vendor=" + vendor
				+ ", emsId=" + emsId + ", serviceStatus=" + serviceStatus + ", fqdnUrl=" + fqdnUrl + ", emsType="
				+ emsType + "]";
	}
	
}
