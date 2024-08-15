package com.qsp.restaurant_management_system.exception;

public class RestaurantAlreadyExists extends RuntimeException{
	private String message = "Restaurant Already Exists";

	public String getMessage() {
		return message;
	}
}
