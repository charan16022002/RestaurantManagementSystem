package com.qsp.restaurant_management_system.exception;

public class PaymentIdNotFound extends RuntimeException{
	private String message = "Payment Id Not Found in DB";

	public String getMessage() {
		return message;
	}
}
