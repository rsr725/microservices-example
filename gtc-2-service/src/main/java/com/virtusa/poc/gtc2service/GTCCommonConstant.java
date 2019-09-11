package com.virtusa.poc.gtc2service;

import java.util.HashMap;
import java.util.Map;

public class GTCCommonConstant {
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0000 = "GTC_TOGGLE_0000";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0001 = "GTC_TOGGLE_0001";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_9000 = "GTC_TOGGLE_9000";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0003 = "GTC_TOGGLE_0003";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0004 = "GTC_TOGGLE_0004";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0005 = "GTC_TOGGLE_0005";
	
	
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0000_MSG = "Toggle switch fibre light on. Caution.";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0001_MSG = "Toggle switch fibre light off.";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_9000_MSG = "Test unsuccessful - DON'T CALL THE HELPDESK - Please re-try once more. If second test fails record failure in your job before closing your task.";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0003_MSG = "Test unsuccessful - Toggle switch off could not be applied successfully.";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0004_MSG = "Toggle status fibre light on. Caution.";
	public static final String EMS_TOGGLE_CODE_GTC_TOGGLE_0005_MSG = "Toggle status fibre light off.";
	
	public static final String EMS_TOGGLE_STATUS_ON = "On";
	public static final String EMS_TOGGLE_STATUS_OFF = "Off";
	public static final String EMS_TOGGLE_OUTCOME_STATUS_PASS = "Pass";
	public static final String EMS_TOGGLE_OUTCOME_STATUS_FAIL = "Fail";
	public static final String EMS_TOGGLE_FAULT_LOCATION_OK = "Ok";
	public static final String EMS_TOGGLE_FAULT_LOCATION_DT = "DT";
	
	public static final Map<String, String> EMS_TOGGLE_CODE_AND_MSG = new HashMap<>();
	static {
		
		EMS_TOGGLE_CODE_AND_MSG.put(EMS_TOGGLE_CODE_GTC_TOGGLE_0000, EMS_TOGGLE_CODE_GTC_TOGGLE_0000_MSG);
		EMS_TOGGLE_CODE_AND_MSG.put(EMS_TOGGLE_CODE_GTC_TOGGLE_0001, EMS_TOGGLE_CODE_GTC_TOGGLE_0001_MSG);
		EMS_TOGGLE_CODE_AND_MSG.put(EMS_TOGGLE_CODE_GTC_TOGGLE_9000, EMS_TOGGLE_CODE_GTC_TOGGLE_9000_MSG);
		EMS_TOGGLE_CODE_AND_MSG.put(EMS_TOGGLE_CODE_GTC_TOGGLE_0003, EMS_TOGGLE_CODE_GTC_TOGGLE_0003_MSG);
		EMS_TOGGLE_CODE_AND_MSG.put(EMS_TOGGLE_CODE_GTC_TOGGLE_0004, EMS_TOGGLE_CODE_GTC_TOGGLE_0004_MSG);
		EMS_TOGGLE_CODE_AND_MSG.put(EMS_TOGGLE_CODE_GTC_TOGGLE_0005, EMS_TOGGLE_CODE_GTC_TOGGLE_0005_MSG);
	}
	
	public static final Map<String, String> EMS_TOGGLE_STATUS = new HashMap<>();
	static {
		EMS_TOGGLE_STATUS.put(EMS_TOGGLE_STATUS_ON, EMS_TOGGLE_CODE_GTC_TOGGLE_0000);
		EMS_TOGGLE_STATUS.put(EMS_TOGGLE_STATUS_OFF, EMS_TOGGLE_CODE_GTC_TOGGLE_0001);
		EMS_TOGGLE_STATUS.put("", EMS_TOGGLE_CODE_GTC_TOGGLE_9000);
	}
	
	public static final String PHOENIX_ERROR_FRIENDLY_MSG = "Phoenix Service is down. Please try again later!";
	public static final String PHOENIX_NOT_FOUND_FRIENDLY_MSG = "EMS details not found in inventory. Please provide correct details!";
	
	public static final String EMS_ERROR_FRIENDLY_MSG = "EMS Service is down. Please try again later!";
	public static final String EMS_NOT_FOUND_FRIENDLY_MSG = "EMS details not found. Please provide correct details!";
	
	public static final String TADDS_ERROR_FRIENDLY_MSG = "TADDS Service is down. Please try again later!";
	public static final String TADDS_NOT_FOUND_FRIENDLY_MSG = "TADDS records not found. Please provide correct details!";
	
	public static final int NOT_FOUND = 404;
}
