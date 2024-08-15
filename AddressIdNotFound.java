package com.qsp.restaurant_management_system.exception;

public class AddressIdNotFound extends RuntimeException {
	private String message = "Address Id Not Found in DB";

	public String getMessage() {
		return message;
	}

}
