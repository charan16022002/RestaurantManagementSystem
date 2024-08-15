package com.qsp.restaurant_management_system.exception;

public class FoodIdNotFound extends RuntimeException{
	private String message = "Food Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
