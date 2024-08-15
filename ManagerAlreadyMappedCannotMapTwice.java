package com.qsp.restaurant_management_system.exception;

public class ManagerAlreadyMappedCannotMapTwice extends RuntimeException {
	private String message = "Manager Already Mapped Cannot Map Twice";

	public String getMessage() {
		return message;
	}

}
