package com.qsp.restaurant_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.FoodDao;
import com.qsp.restaurant_management_system.dao.MenuDao;
import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.exception.FoodAlreadyMappedToMenu;
import com.qsp.restaurant_management_system.exception.FoodIdNotFound;
import com.qsp.restaurant_management_system.exception.MenuIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;
	@Autowired
	FoodDao foodDao;
	@Autowired
	ResponseStructure<Menu> responseStructure;
	@Autowired
	ResponseStructureList<Menu> responseStructureList;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully menu inserted into DB");
		responseStructure.setData(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> fetchMenuById(int menuId) {
		Menu menu = menuDao.fetchMenuById(menuId);
		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully menu fetched from DB");
			responseStructure.setData(menuDao.fetchMenuById(menuId));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenuById(int menuId) {
		Menu menu = menuDao.fetchMenuById(menuId);
		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully menu deleted from DB");
			responseStructure.setData(menuDao.deleteMenuById(menuId));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int oldId, Menu newMenu) {
		Menu menu = menuDao.fetchMenuById(oldId);
		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully menu updated into DB");
			responseStructure.setData(menuDao.updateMenu(oldId, newMenu));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Menu>> findAllMenu() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all menus fetched from DB");
		responseStructureList.setData(menuDao.findAllMenu());
		return new ResponseEntity<ResponseStructureList<Menu>>(responseStructureList, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Menu>> addExistingFoodToExistingMenu(int menuId, int foodId) {
		Menu menu = menuDao.fetchMenuById(menuId);
		Food food = foodDao.fetchFoodById(foodId);
//		List<Food> food2=menu.getFood();
		List<Menu> menus=menuDao.findAllMenu();
//		for(Food food3:food2)
//		{
//			if(food3.getFoodId()==(foodId))
//			{
//				throw new FoodAlreadyMappedToMenu();
//			}
//		}
		for(Menu menu2:menus)
		{
			Menu menu4=menu2;
			List<Food> food4=menu4.getFood();
			for(Food food5:food4)
			{
				if(food5.getFoodId()==(foodId))
				{
					throw new FoodAlreadyMappedToMenu();
				}
			}
		}
		if (food != null && menu != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added Existing Food To Existing Menu");
			responseStructure.setData(menuDao.addExistingFoodToExistingMenu(menuId, foodId));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else if (menu == null) {
			throw new MenuIdNotFound();
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> addNewFoodToExistingMenu(int menuId, Food food) {
		Menu menu = menuDao.fetchMenuById(menuId);
		if (menu != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added New Food To Existing Menu");
			responseStructure.setData(menuDao.addNewFoodToExistingMenu(menuId, food));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFound();
		}

	}

}
