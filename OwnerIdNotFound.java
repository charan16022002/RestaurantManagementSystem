package com.qsp.restaurant_management_system.exception;

public class OwnerIdNotFound extends RuntimeException{
	private String message = "Owner Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
