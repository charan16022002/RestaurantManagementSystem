package com.qsp.restaurant_management_system.exception;

public class CustomerIdNotFound extends RuntimeException {
	private String message = "Customer Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
