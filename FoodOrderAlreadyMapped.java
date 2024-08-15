package com.qsp.restaurant_management_system.exception;

public class FoodOrderAlreadyMapped extends RuntimeException {
	private String message = "foodorder Already Mapped Cannot Map Twice";

	public String getMessage() {
		return message;
	}
}
