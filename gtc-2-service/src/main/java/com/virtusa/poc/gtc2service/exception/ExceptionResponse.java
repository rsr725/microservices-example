package com.virtusa.poc.gtc2service.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String friendlyMsg;
	private String details;
	public ExceptionResponse(Date timestamp, String friendlyMsg, String details) {
		super();
		this.timestamp = timestamp;
		this.friendlyMsg = friendlyMsg;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getFriendlyMsg() {
		return friendlyMsg;
	}
	public void setFriendlyMsg(String friendlyMsg) {
		this.friendlyMsg = friendlyMsg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	
}