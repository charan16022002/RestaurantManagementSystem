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

import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.service.RestaurantService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	@PostMapping("/saveRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.saveRestaurant(restaurant);
	}
	@GetMapping("/fetchRestaurantById")
	public ResponseEntity<ResponseStructure<Restaurant>> fetchRestaurantById(@RequestParam int restaurantId) {
		return restaurantService.fetchRestaurantById(restaurantId);
	}
	@DeleteMapping("/deleteRestaurantById")
	public ResponseEntity<ResponseStructure<Restaurant>> deleteRestaurantById(@RequestParam int restaurantId) {
		return restaurantService.deleteRestaurantById(restaurantId);
	}
	@PutMapping("/updateRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(@RequestParam int oldId,@RequestBody Restaurant newRestaurant) {
		return restaurantService.updateRestaurant(oldId, newRestaurant);
	}
	@GetMapping("/findAllRestaurant")
	public ResponseEntity<ResponseStructureList<Restaurant>> findAllRestaurant() {
		return restaurantService.findAllRestaurant();
	}
	@PutMapping("/addExistingBranchToExistingRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> addExistingBranchToExistingRestaurant(@RequestParam int restaurantId,@RequestParam int branchId)
	{
		return restaurantService.addExistingBranchToExistingRestaurant(restaurantId, branchId);
		
	}
	@PutMapping("/addNewBranchToExistingRestaurant")
	public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchToExistingRestaurant(@RequestParam int restaurantId,@RequestBody Branch branch)
	{
		return restaurantService.addNewBranchToExistingRestaurant(restaurantId, branch);
	}

}
