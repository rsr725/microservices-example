package com.virtusa.poc.gtc2service.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GTCEMSToggle {
	
	private long id;
	private String emsId;
	private String headendId;
	private String emsHeadendPort;
	private String description;
	private String toggleCode;
	private String status;
	@JsonIgnore
	private String port;
	private String friendlyMsg;
	private String outcomeStatus;
	private Date modifiedTime;
	@JsonIgnore
	private String errorCode;
	
	public GTCEMSToggle() {
		super();
	}

	public GTCEMSToggle(long id, String emsId, String headendId, String emsHeadendPort, String description,
			String toggleCode, String status, String port, String friendlyMsg, String outcomeStatus,
			Date modifiedTime) {
		super();
		this.id = id;
		this.emsId = emsId;
		this.headendId = headendId;
		this.emsHeadendPort = emsHeadendPort;
		this.description = description;
		this.toggleCode = toggleCode;
		this.status = status;
		this.port = port;
		this.friendlyMsg = friendlyMsg;
		this.outcomeStatus = outcomeStatus;
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

	public String getToggleCode() {
		return toggleCode;
	}

	public void setToggleCode(String toggleCode) {
		this.toggleCode = toggleCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getFriendlyMsg() {
		return friendlyMsg;
	}

	public void setFriendlyMsg(String friendlyMsg) {
		this.friendlyMsg = friendlyMsg;
	}

	public String getOutcomeStatus() {
		return outcomeStatus;
	}

	public void setOutcomeStatus(String outcomeStatus) {
		this.outcomeStatus = outcomeStatus;
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
		return "GTCEMSToggle [id=" + id + ", emsId=" + emsId + ", headendId=" + headendId + ", emsHeadendPort="
				+ emsHeadendPort + ", description=" + description + ", toggleCode=" + toggleCode + ", status=" + status
				+ ", port=" + port + ", friendlyMsg=" + friendlyMsg + ", outcomeStatus=" + outcomeStatus
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	
}
