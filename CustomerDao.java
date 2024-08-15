package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.repo.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public Customer saveCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}
	public Customer fetchCustomerById(int customerId)
	{
		Optional<Customer> customer=customerRepo.findById(customerId);
		if(customer.isEmpty())
		{
			return null;
		}
		return customer.get();
	}
	public Customer deleteCustomerById(int customerId)
	{
		Customer customer=fetchCustomerById(customerId);
		customerRepo.delete(customer);
		return customer;
	}
	public Customer updateCustomer(int oldId,Customer newCustomer)
	{
		newCustomer.setCustomerId(oldId);
		return customerRepo.save(newCustomer);
	}
	public List<Customer> findAllCustomers()
	{
		return customerRepo.findAll();
	}
	public Customer addExistingFoodOrderToExistingCustomer(int foodOrderId,int customerId)
	{
		Customer customer=fetchCustomerById(customerId);
		FoodOrder foodOrder=foodOrderDao.fetchFoodOrderById(foodOrderId);
		List<FoodOrder> list=customer.getFoodOrder();
		list.add(foodOrder);
		customer.setFoodOrder(list);
		return saveCustomer(customer);
		
	}
	public Customer addNewFoodOrderToExistingCustomer(FoodOrder foodOrder,int customerId)
	{
		Customer customer=fetchCustomerById(customerId);
		List<FoodOrder> list=customer.getFoodOrder();
		list.add(foodOrder);
		customer.setFoodOrder(list);
		return saveCustomer(customer);
		
	}
}
