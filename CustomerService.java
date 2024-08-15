package com.qsp.restaurant_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.CustomerDao;
import com.qsp.restaurant_management_system.dao.FoodOrderDao;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.exception.CustomerIdNotFound;
import com.qsp.restaurant_management_system.exception.FoodOrderAlreadyMapped;
import com.qsp.restaurant_management_system.exception.FoodOrderIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	FoodOrderDao foodOrderDao;
	@Autowired
	ResponseStructure<Customer> responseStructure;
	@Autowired
	ResponseStructureList<Customer> responseStructureList;

	public ResponseEntity<ResponseStructure<Customer>> saveCustomer(Customer customer) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully customer inserted into DB");
		responseStructure.setData(customerDao.saveCustomer(customer));
		return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Customer>> fetchCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully customer fetched from DB");
			responseStructure.setData(customerDao.fetchCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> deleteCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully customer deleted from DB");
			responseStructure.setData(customerDao.deleteCustomerById(customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(int oldId, Customer newCustomer) {
		Customer customer = customerDao.fetchCustomerById(oldId);
		if (customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully customer updated into DB");
			responseStructure.setData(customerDao.updateCustomer(oldId, newCustomer));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Customer>> findAllCustomers() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all customers fetched from DB");
		responseStructureList.setData(customerDao.findAllCustomers());
		return new ResponseEntity<ResponseStructureList<Customer>>(responseStructureList, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Customer>> addExistingFoodOrderToExistingCustomer(int foodOrderId,
			int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		List<Customer> customers=customerDao.findAllCustomers();
		for(Customer customer2:customers) {
			List<FoodOrder> foodOrders=customer2.getFoodOrder();
			for(FoodOrder foodOrder2:foodOrders)
			{
				if(foodOrder2.getFoodOrderId()==foodOrderId)
				{
					throw new FoodOrderAlreadyMapped();
				}
			}
		}
		if (foodOrder != null && customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added Existing FoodOrder To Existing Customer");
			responseStructure.setData(customerDao.addExistingFoodOrderToExistingCustomer(foodOrderId, customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else if (foodOrder == null) {
			throw new FoodOrderIdNotFound();
		} else {
			throw new CustomerIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Customer>> addNewFoodOrderToExistingCustomer(FoodOrder foodOrder,
			int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added New FoodOrder To Existing Customer");
			responseStructure.setData(customerDao.addNewFoodOrderToExistingCustomer(foodOrder, customerId));
			return new ResponseEntity<ResponseStructure<Customer>>(responseStructure, HttpStatus.OK);
		} else {
			throw new CustomerIdNotFound();
		}
	}
}
