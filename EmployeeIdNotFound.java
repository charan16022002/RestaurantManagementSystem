package com.qsp.restaurant_management_system.exception;

public class EmployeeIdNotFound extends RuntimeException{
	private String message = "Employee Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
