package com.qsp.restaurant_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	private String restaurantName;
	private String restaurantEmail;
	private long restaurantPhone;
	private String restaurantGST;
	@OneToMany(cascade = CascadeType.ALL)
	List<Branch> branch;
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantEmail() {
		return restaurantEmail;
	}
	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}
	public long getRestaurantPhone() {
		return restaurantPhone;
	}
	public void setRestaurantPhone(long restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}
	public String getRestaurantGST() {
		return restaurantGST;
	}
	public void setRestaurantGST(String restaurantGST) {
		this.restaurantGST = restaurantGST;
	}
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	
}
