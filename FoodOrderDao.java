package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {
	
	@Autowired
	FoodOrderRepo foodOrderRepo;
	@Autowired
	PaymentDao paymentDao;
	
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder)
	{
		return foodOrderRepo.save(foodOrder);
	}
	public FoodOrder fetchFoodOrderById(int foodOrderId)
	{
		Optional<FoodOrder> foodOrder=foodOrderRepo.findById(foodOrderId);
		if(foodOrder.isEmpty())
		{
			return null;
			
		}
		return foodOrder.get();
	}
	public FoodOrder deleteFoodOrderById(int foodOrderId)
	{
		FoodOrder foodOrder=fetchFoodOrderById(foodOrderId);
		foodOrderRepo.delete(foodOrder);
		return foodOrder;
	}
	public FoodOrder updateFoodOrder(int oldId,FoodOrder newFoodOrder)
	{
		newFoodOrder.setFoodOrderId(oldId);
		return foodOrderRepo.save(newFoodOrder);
	}
	public List<FoodOrder> findAllFoodOrders()
	{
		return foodOrderRepo.findAll();
	}
	public FoodOrder addExistingPaymentToFoodOrder(int foodOrderId,int paymentId)
	{
		FoodOrder foodOrder=fetchFoodOrderById(foodOrderId);
		Payment payment=paymentDao.fetchPaymentById(paymentId);
		foodOrder.setPayment(payment);
		return saveFoodOrder(foodOrder);
	}
	public FoodOrder addNewPaymentToExistingFoodOrder(int foodOrderId,Payment payment)
	{
		FoodOrder foodOrder=fetchFoodOrderById(foodOrderId);
		foodOrder.setPayment(payment);
		return saveFoodOrder(foodOrder);
	}

}
