package com.qsp.restaurant_management_system.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuId;
	private String menuCategory;
	private String menuNoOfItems;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Food> food;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuCategory() {
		return menuCategory;
	}
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}
	public String getMenuNoOfItems() {
		return menuNoOfItems;
	}
	public void setMenuNoOfItems(String menuNoOfItems) {
		this.menuNoOfItems = menuNoOfItems;
	}
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	
}
