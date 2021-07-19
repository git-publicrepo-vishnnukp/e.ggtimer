package com.ui.automation.common;

public enum DataEnums {

	COUNTDOWN_TIME("enter_time");

	private final String message;

	DataEnums(String message) {
		this.message = message;
	}

	public String getValue() {
		return message;
	}

}