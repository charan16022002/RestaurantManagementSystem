package com.qsp.restaurant_management_system.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;
	private String ownerName;
	private long ownerPhone;
	private double ownerNetWorth;
	@OneToOne(cascade = CascadeType.ALL)
	private Restaurant restaurant;
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(long ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public double getOwnerNetWorth() {
		return ownerNetWorth;
	}
	public void setOwnerNetWorth(double ownerNetWorth) {
		this.ownerNetWorth = ownerNetWorth;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
