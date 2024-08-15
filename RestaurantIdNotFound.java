package com.qsp.restaurant_management_system.exception;

public class RestaurantIdNotFound extends RuntimeException{
	private String message = "Restaurant Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
