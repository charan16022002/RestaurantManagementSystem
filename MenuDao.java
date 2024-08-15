package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.repo.MenuRepo;

@Repository
public class MenuDao {
	@Autowired
	MenuRepo menuRepo;
	@Autowired
	FoodDao foodDao;
	
	public Menu saveMenu(Menu menu)
	{
		return menuRepo.save(menu);
	}
	public Menu fetchMenuById(int menuId)
	{
		Optional<Menu> menu=menuRepo.findById(menuId);
		if((menu.isEmpty()))
		{
			return null;
		}
		return menu.get();
	}
	public Menu deleteMenuById(int menuId)
	{
		Menu menu=fetchMenuById(menuId);
		menuRepo.delete(menu);
		return menu;
	}
	public Menu updateMenu(int oldId,Menu newMenu)
	{
		newMenu.setMenuId(oldId);
		return menuRepo.save(newMenu);
	}
	public List<Menu> findAllMenu()
	{
		return menuRepo.findAll();
	}
	public Menu addExistingFoodToExistingMenu(int menuId,int foodId)
	{
		Menu menu=fetchMenuById(menuId);
		Food food=foodDao.fetchFoodById(foodId);
		List<Food> list=menu.getFood();
		list.add(food);
		menu.setFood(list);
		return saveMenu(menu);
	}
	public Menu addNewFoodToExistingMenu(int menuId,Food food)
	{
		Menu menu=fetchMenuById(menuId);
		List<Food> list=menu.getFood();
		list.add(food);
		menu.setFood(list);
		return saveMenu(menu);
	}
}
