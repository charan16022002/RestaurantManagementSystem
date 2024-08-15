package com.qsp.restaurant_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.BranchDao;
import com.qsp.restaurant_management_system.dao.RestaurantDao;
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.exception.BranchAlreadyExists;
import com.qsp.restaurant_management_system.exception.BranchIdNotFound;
import com.qsp.restaurant_management_system.exception.RestaurantIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class RestaurantService {
	@Autowired
	RestaurantDao restaurantDao;
	@Autowired
	BranchDao branchDao;
	@Autowired
	ResponseStructure<Restaurant> responseStructure;
	@Autowired
	ResponseStructureList<Restaurant> responseStructureList;

	public ResponseEntity<ResponseStructure<Restaurant>> saveRestaurant(Restaurant restaurant) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully restaurant inserted into DB");
		responseStructure.setData(restaurantDao.saveRestaurant(restaurant));
		return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Restaurant>> fetchRestaurantById(int restaurantId) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(restaurantId);
		if (restaurant != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully restaurant fetched from DB");
			responseStructure.setData(restaurantDao.fetchRestaurantById(restaurantId));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Restaurant>> deleteRestaurantById(int restaurantId) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(restaurantId);
		if (restaurant != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully restaurant deleted from DB");
			responseStructure.setData(restaurantDao.deleteRestaurantById(restaurantId));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Restaurant>> updateRestaurant(int oldId, Restaurant newRestaurant) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(oldId);
		if (restaurant != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully restaurant updated from DB");
			responseStructure.setData(restaurantDao.updateRestaurant(oldId, newRestaurant));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Restaurant>> findAllRestaurant() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully restaurant inserted into DB");
		responseStructureList.setData(restaurantDao.findAllRestaurant());
		return new ResponseEntity<ResponseStructureList<Restaurant>>(responseStructureList, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Restaurant>> addExistingBranchToExistingRestaurant(int restaurantId,
			int branchId) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(restaurantId);
		Branch branch = branchDao.fetchBranchById(branchId);
		List<Restaurant> restaurants=restaurantDao.findAllRestaurant();
		for(Restaurant restaurant2:restaurants)
		{
			List<Branch> branchs=restaurant2.getBranch();
			for(Branch branch2:branchs)
			{
				if(branch2.getBranchId()==branchId)
				{
					throw new BranchAlreadyExists();
				}
			}
		}
		if (branch != null && restaurant != null) {

			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added Existing Branch To Existing Restaurant");
			responseStructure.setData(restaurantDao.addExistingBranchToExistingRestaurant(restaurantId, branchId));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else if (branch == null) {
			throw new BranchIdNotFound();
		} else {
			throw new RestaurantIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Restaurant>> addNewBranchToExistingRestaurant(int restaurantId,
			Branch branch) {
		Restaurant restaurant = restaurantDao.fetchRestaurantById(restaurantId);
		if (restaurant != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added New Branch To Existing Restaurant");
			responseStructure.setData(restaurantDao.addNewBranchToExistingRestaurant(restaurantId, branch));
			return new ResponseEntity<ResponseStructure<Restaurant>>(responseStructure, HttpStatus.OK);
		} else {
			throw new RestaurantIdNotFound();
		}
	}

}
