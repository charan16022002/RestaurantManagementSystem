package com.qsp.restaurant_management_system.exception;

public class ManagerIdNotFound extends RuntimeException{
	private String message = "Manager Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
