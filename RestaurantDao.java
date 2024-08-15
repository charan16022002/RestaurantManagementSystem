package com.qsp.restaurant_management_system.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.repo.RestaurantRepo;

@Repository
public class RestaurantDao {

	@Autowired
	RestaurantRepo restaurantRepo;
	@Autowired
	BranchDao branchDao;
	
	public Restaurant saveRestaurant(Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}

	public Restaurant fetchRestaurantById(int restaurantId) {
		Optional<Restaurant> restaurant=restaurantRepo.findById(restaurantId);
		if(restaurant.isEmpty())
		{
			return null;
		}
		return restaurant.get();
	}

	public Restaurant deleteRestaurantById(int restaurantId) {
		Restaurant restaurant = fetchRestaurantById(restaurantId);
		restaurantRepo.delete(restaurant);
		return restaurant;
	}

	public Restaurant updateRestaurant(int oldId, Restaurant newRestaurant) {
		newRestaurant.setRestaurantId(oldId);
		return restaurantRepo.save(newRestaurant);
	}

	public List<Restaurant> findAllRestaurant() {
		return restaurantRepo.findAll();
	}
	public Restaurant addExistingBranchToExistingRestaurant(int restaurantId,int branchId)
	{
		Restaurant restaurant=fetchRestaurantById(restaurantId);
		Branch branch=branchDao.fetchBranchById(branchId);
		//List<Branch> list=new ArrayList<Branch>();
		List<Branch> list=restaurant.getBranch();
		list.add(branch);
		restaurant.setBranch(list);
		return saveRestaurant(restaurant);
		
	}
	public Restaurant addNewBranchToExistingRestaurant(int restaurantId,Branch branch)
	{
		Restaurant restaurant=fetchRestaurantById(restaurantId);
		List<Branch> list=restaurant.getBranch();
		list.add(branch);
		restaurant.setBranch(list);
		return saveRestaurant(restaurant);
	}
}
