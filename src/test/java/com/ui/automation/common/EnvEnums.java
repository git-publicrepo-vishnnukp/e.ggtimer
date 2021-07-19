package com.ui.automation.common;

public enum EnvEnums {

	APPLICATION_URL("application_url"),
	EXPLICIT_WAIT_TIME_IN_MILLISECONDS("explicit_wait_time");

	private final String message;
	
	EnvEnums(String message) {
		this.message = message;
	}

	public String getValue() {
		return message;
	}

}