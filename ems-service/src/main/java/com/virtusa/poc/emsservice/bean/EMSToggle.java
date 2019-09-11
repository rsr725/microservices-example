package com.virtusa.poc.emsservice.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class EMSToggle {
	
	@Id
	private long id;
	private String emsId;
	private String headendId;
	private String emsHeadendPort;
	private String description;
	private String status;
	private Date modifiedTime;
	@Transient
	private String errorCode;
	
	public EMSToggle() {
		super();
	}

	public EMSToggle(long id, String emsId, String headendId, String emsHeadendPort, String description,
			String status, Date modifiedTime) {
		super();
		this.id = id;
		this.emsId = emsId;
		this.headendId = headendId;
		this.emsHeadendPort = emsHeadendPort;
		this.description = description;
		this.status = status;
		this.modifiedTime = modifiedTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmsId() {
		return emsId;
	}

	public void setEmsId(String emsId) {
		this.emsId = emsId;
	}

	public String getHeadendId() {
		return headendId;
	}

	public void setHeadendId(String headendId) {
		this.headendId = headendId;
	}

	public String getEmsHeadendPort() {
		return emsHeadendPort;
	}

	public void setEmsHeadendPort(String emsHeadendPort) {
		this.emsHeadendPort = emsHeadendPort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "EMSToggle [id=" + id + ", emsId=" + emsId + ", headendId=" + headendId + ", emsHeadendPort="
				+ emsHeadendPort + ", description=" + description + ", status=" + status
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
	
}
