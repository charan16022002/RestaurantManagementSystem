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

import com.qsp.restaurant_management_system.dto.Owner;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.service.OwnerService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@RestController
public class OwnerController {

	
	@Autowired
	OwnerService ownerService;
	
	@PostMapping("/saveOwner")
	public ResponseEntity<ResponseStructure<Owner>> saveOwner(@RequestBody Owner owner) {
		return ownerService.saveOwner(owner);
	}
	@GetMapping("/fetchOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(@RequestParam int ownerId) {
		return ownerService.fetchOwnerById(ownerId);
	}
	@DeleteMapping("/deleteOwnerById")
	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}
	@PutMapping("/updateOwner")
	public ResponseEntity<ResponseStructure<Owner>> updateOwner(@RequestParam int oldId,@RequestBody Owner newOwner) {
		return ownerService.updateOwner(oldId, newOwner);
	}
	@GetMapping("/findAllOwner")
	public ResponseEntity<ResponseStructureList<Owner>> findAllOwner() {
		return ownerService.findAllOwner();
	}
	@PutMapping("/addExistingRestaurantToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addExistingRestaurantToExistingOwner(@RequestParam int ownerId,@RequestParam int restaurantId)
	{
		return ownerService.addExistingRestaurantToExistingOwner(ownerId, restaurantId);
	}
	@PutMapping("/addNewRestaurantToExistingOwner")
	public ResponseEntity<ResponseStructure<Owner>> addNewRestaurantToExistingOwner(@RequestParam int ownerId,@RequestBody Restaurant restaurant)
	{
		return ownerService.addNewRestaurantToExistingOwner(ownerId, restaurant);
	}
}
