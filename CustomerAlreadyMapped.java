package com.qsp.restaurant_management_system.exception;

public class CustomerAlreadyMapped extends RuntimeException {
	private String message = "Customer Already Mapped Cannot Map Twice";

	public String getMessage() {
		return message;
	}
}
