package com.qsp.restaurant_management_system.exception;

public class EmployeeAlreadyMapped extends RuntimeException {
	private String message = "Employee Already Mapped Cannot Map Twice";

	public String getMessage() {
		return message;
	}
}
