package com.qsp.restaurant_management_system.exception;

public class MenuIdNotFound extends RuntimeException{
	private String message = "Menu Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
