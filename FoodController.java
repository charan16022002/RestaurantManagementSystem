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

import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.service.FoodService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@RestController
public class FoodController {

	@Autowired
	FoodService foodService;
	@PostMapping("/saveFood")
	public ResponseEntity<ResponseStructure<Food>> saveFood(@RequestBody Food food)
	{
		return foodService.saveFood(food);
	}
	@GetMapping("/fetchFoodById")
	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(@RequestParam int foodId)
	{
		return foodService.fetchFoodById(foodId);
	}
	@DeleteMapping("/deleteFoodById")
	public ResponseEntity<ResponseStructure<Food>> deleteFoodById(@RequestParam int foodId)
	{
		
		return foodService.deleteFoodById(foodId);
	}
	@PutMapping("/updateFood")
	public ResponseEntity<ResponseStructure<Food>> updateFood(@RequestParam int oldId,@RequestBody Food newFood)
	{
		return foodService.updateFood(oldId, newFood);
	}
	@GetMapping("/findAllFoods")
	public ResponseEntity<ResponseStructureList<Food>> findAllFoods()
	{
		return foodService.findAllFoods();
	}
	@PutMapping("/addExistingFoodOrderToExistingFood")
	public ResponseEntity<ResponseStructure<Food>> addExistingFoodOrderToExistingFood(@RequestParam int foodId,@RequestParam int foodOrderId)
	{
		return foodService.addExistingFoodOrderToExistingFood(foodId, foodOrderId);
	}
	@PutMapping("/addNewFoodOrderToExistingFood")
	public ResponseEntity<ResponseStructure<Food>> addNewFoodOrderToExistingFood(@RequestParam int foodId,@RequestBody FoodOrder foodOrder)
	{
		return foodService.addNewFoodOrderToExistingFood(foodId, foodOrder);
	}
}
