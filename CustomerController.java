package com.qsp.restaurant_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.service.CustomerService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@GetMapping("/fetchCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}
	@DeleteMapping("/deleteCustomerById")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}
	@PutMapping("/updateCustomer")
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestParam int oldId,@RequestBody Customer newCustomer) {
		return customerService.updateCustomer(oldId, newCustomer);
	}
	@GetMapping("/findAllCustomers")
	public ResponseEntity<ResponseStructureList<Customer>> findAllCustomers() {
		return customerService.findAllCustomers();
	}
	@PutMapping("/addExistingFoodOrderToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addExistingFoodOrderToExistingCustomer(@RequestParam int foodOrderId,@RequestParam int customerId)
	{
		return customerService.addExistingFoodOrderToExistingCustomer(foodOrderId, customerId);
		
	}
	@PutMapping("/addNewFoodOrderToExistingCustomer")
	public ResponseEntity<ResponseStructure<Customer>> addNewFoodOrderToExistingCustomer(@RequestBody FoodOrder foodOrder,@RequestParam int customerId)
	{
		return customerService.addNewFoodOrderToExistingCustomer(foodOrder, customerId);
		
	}


}
