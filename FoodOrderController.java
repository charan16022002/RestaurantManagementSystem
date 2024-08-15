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

import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.service.FoodOrderService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@RestController
public class FoodOrderController {

	
	@Autowired
	FoodOrderService foodOrderService;
	
	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder)
	{
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	@GetMapping("/fetchFoodOrderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> fetchFoodOrderById(@RequestParam int foodOrderId)
	{
		return foodOrderService.fetchFoodOrderById(foodOrderId);
	}
	@DeleteMapping("/deleteFoodOrderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrderById(@RequestParam int foodOrderId)
	{
		return foodOrderService.deleteFoodOrderById(foodOrderId);
	}
	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestParam int oldId,@RequestBody FoodOrder newFoodOrder)
	{
		return foodOrderService.updateFoodOrder(oldId, newFoodOrder);
	}
	@GetMapping("/findAllFoodOrders")
	public ResponseEntity<ResponseStructureList<FoodOrder>> findAllFoodOrders()
	{
		return foodOrderService.findAllFoodOrders();
	}
	@PutMapping("/addExistingPaymentToFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> addExistingPaymentToFoodOrder(@RequestParam int foodOrderId,@RequestParam int paymentId)
	{
	return foodOrderService.addExistingPaymentToFoodOrder(foodOrderId, paymentId);
	}
	@PutMapping("/addNewPaymentToExistingFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> addNewPaymentToExistingFoodOrder(@RequestParam int foodOrderId,@RequestBody Payment payment)
	{
		
		return foodOrderService.addNewPaymentToExistingFoodOrder(foodOrderId, payment);
	}
}
