package com.virtusa.poc.gtc2service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import feign.FeignException;


@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceDownException extends FeignException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4843724196454142625L;
 
	public ServiceDownException(int status, String friendlyMsg) {
		super(status, friendlyMsg);
	}
}
