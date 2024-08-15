package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Owner;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {
	@Autowired
	OwnerRepo ownerRepo;
	@Autowired
	RestaurantDao restaurantDao;

	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}

	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner=ownerRepo.findById(ownerId);
		if(owner.isEmpty())
		{
			return null;
		}
		return owner.get();
	}

	public Owner deleteOwnerById(int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}

	public Owner updateOwner(int oldId, Owner newOwner) {
		newOwner.setOwnerId(oldId);
		return ownerRepo.save(newOwner);
	}

	public List<Owner> findAllOwner() {
		return ownerRepo.findAll();
	}
	public Owner addExistingRestaurantToExistingOwner(int ownerId,int restaurantId)
	{
		Owner owner=fetchOwnerById(ownerId);
		Restaurant restaurant=restaurantDao.fetchRestaurantById(restaurantId);
		owner.setRestaurant(restaurant);
		return saveOwner(owner);
	}
	public Owner addNewRestaurantToExistingOwner(int ownerId,Restaurant restaurant)
	{
		Owner owner=fetchOwnerById(ownerId);
		owner.setRestaurant(restaurant);
		return saveOwner(owner);
	}
}
