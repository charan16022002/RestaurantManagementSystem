package com.qsp.restaurant_management_system.exception;

public class FoodAlreadyMappedToMenu extends RuntimeException {
	private String message = "Food Already Mapped To Menu";

	public String getMessage() {
		return message;
	}

}
