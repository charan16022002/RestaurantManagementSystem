package com.qsp.restaurant_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.restaurant_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@Autowired
	ResponseStructure responseStructure;
	
	@ExceptionHandler(OwnerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> addressIdNotFound(AddressIdNotFound addressIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(addressIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> branchIdNotFound(BranchIdNotFound branchIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(branchIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CustomerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> customerIdNotFound(CustomerIdNotFound customerIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(customerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmployeeIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(employeeIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> foodIdNotFound(FoodIdNotFound foodIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(foodIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FoodOrderIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> foodOrderIdNotFound(FoodOrderIdNotFound foodOrderIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(foodOrderIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ManagerIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> managerIdNotFound(ManagerIdNotFound managerIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(managerIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MenuIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> menuIdNotFound(MenuIdNotFound menuIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(menuIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> paymentIdNotFound(PaymentIdNotFound paymentIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(paymentIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RestaurantIdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> restaurantIdNotFound(RestaurantIdNotFound restaurantIdNotFound)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id not found");
		responseStructure.setData(restaurantIdNotFound.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ManagerAlreadyMappedCannotMapTwice.class)
	public ResponseEntity<ResponseStructure<String>> managerAlreadyMappedCannotMapTwice(ManagerAlreadyMappedCannotMapTwice managerAlreadyMappedCannotMapTwice)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Manager Already Mapped Cannot Map Twice");
		responseStructure.setData(managerAlreadyMappedCannotMapTwice.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FoodAlreadyMappedToMenu.class)
	public ResponseEntity<ResponseStructure<String>> foodAlreadyMappedToMenu(FoodAlreadyMappedToMenu foodAlreadyMappedToMenu)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Food Already Mapped To Menu");
		responseStructure.setData(foodAlreadyMappedToMenu.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmployeeAlreadyMapped.class)
	public ResponseEntity<ResponseStructure<String>> employeeAlreadyMapped(EmployeeAlreadyMapped employeeAlreadyMapped)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("employee Already Mapped To branch");
		responseStructure.setData(employeeAlreadyMapped.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MenuAlreadyMapped.class)
	public ResponseEntity<ResponseStructure<String>> menuAlreadyMapped(MenuAlreadyMapped menuAlreadyMapped)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("menu Already Mapped To Menu");
		responseStructure.setData(menuAlreadyMapped.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CustomerAlreadyMapped.class)
	public ResponseEntity<ResponseStructure<String>> customerAlreadyMapped(CustomerAlreadyMapped customerAlreadyMapped)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("customer Already Mapped To Menu");
		responseStructure.setData(customerAlreadyMapped.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AddressAlreadyMapped.class)
	public ResponseEntity<ResponseStructure<String>> addressAlreadyMapped(AddressAlreadyMapped addressAlreadyMapped)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("address Already Mapped To Menu");
		responseStructure.setData(addressAlreadyMapped.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FoodOrderAlreadyMapped.class)
	public ResponseEntity<ResponseStructure<String>> foodOrderAlreadyMapped(FoodOrderAlreadyMapped foodOrderAlreadyMapped)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("foodorder Already Mapped To Menu");
		responseStructure.setData(foodOrderAlreadyMapped.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(PaymentAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> paymentAlreadyExists(PaymentAlreadyExists paymentAlreadyExists)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Payment Already Exists");
		responseStructure.setData(paymentAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RestaurantAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> restaurantAlreadyExists(RestaurantAlreadyExists restaurantAlreadyExists)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Restaurant Already Exists");
		responseStructure.setData(restaurantAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BranchAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> branchAlreadyExists(BranchAlreadyExists branchAlreadyExists)
	{
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("branch Already Exists");
		responseStructure.setData(branchAlreadyExists.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	

}
