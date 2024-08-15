package com.qsp.restaurant_management_system.exception;

public class PaymentAlreadyExists  extends RuntimeException{
	private String message = "Payment Already Exists";

	public String getMessage() {
		return message;
	}
}
