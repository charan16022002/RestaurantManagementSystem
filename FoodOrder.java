package com.qsp.restaurant_management_system.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodOrderId;
	private String foodOrderType;
	private int foodOrderQuantity;
	private double foodOrderGST;
	private double foodOrderPrice;
	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;
	public int getFoodOrderId() {
		return foodOrderId;
	}
	public void setFoodOrderId(int foodOrderId) {
		this.foodOrderId = foodOrderId;
	}
	public String getFoodOrderType() {
		return foodOrderType;
	}
	public void setFoodOrderType(String foodOrderType) {
		this.foodOrderType = foodOrderType;
	}
	public int getFoodOrderQuantity() {
		return foodOrderQuantity;
	}
	public void setFoodOrderQuantity(int foodOrderQuantity) {
		this.foodOrderQuantity = foodOrderQuantity;
	}
	public double getFoodOrderGST() {
		return foodOrderGST;
	}
	public void setFoodOrderGST(double foodOrderGST) {
		this.foodOrderGST = foodOrderGST;
	}
	public double getFoodOrderPrice() {
		return foodOrderPrice;
	}
	public void setFoodOrderPrice(double foodOrderPrice) {
		this.foodOrderPrice = foodOrderPrice;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
