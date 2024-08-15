package com.qsp.restaurant_management_system.exception;

public class BranchAlreadyExists extends RuntimeException{
	private String message = "Branch Already Exists";

	public String getMessage() {
		return message;
	}
}
