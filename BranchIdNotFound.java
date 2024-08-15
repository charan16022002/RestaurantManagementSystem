package com.qsp.restaurant_management_system.exception;

public class BranchIdNotFound extends RuntimeException{
	private String message = "Branch Id Not Found in DB";

	public String getMessage() {
		return message;
	}

}
