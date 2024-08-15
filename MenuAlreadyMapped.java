package com.qsp.restaurant_management_system.exception;

public class MenuAlreadyMapped extends RuntimeException {
	private String message = "Menu Already Mapped Cannot Map Twice";

	public String getMessage() {
		return message;
	}
}
