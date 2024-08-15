package com.qsp.restaurant_management_system.exception;

public class FoodOrderIdNotFound extends RuntimeException{
	private String message = "FoodOrder Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
