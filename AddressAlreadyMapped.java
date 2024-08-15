package com.qsp.restaurant_management_system.exception;

public class AddressAlreadyMapped extends RuntimeException {
	private String message = "address Already Mapped Cannot Map Twice";

	public String getMessage() {
		return message;
}
}
