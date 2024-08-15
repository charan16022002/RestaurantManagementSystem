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

import com.qsp.restaurant_management_system.dto.Food;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.service.MenuService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@RestController
public class MenuController {

	
	@Autowired
	MenuService menuService;
	
	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu)
	{
		return menuService.saveMenu(menu);
	}
	@GetMapping("/fetchMenuById")
	public ResponseEntity<ResponseStructure<Menu>> fetchMenuById(@RequestParam int menuId)
	{
		return menuService.fetchMenuById(menuId);
	}
	@DeleteMapping("/deleteMenuById")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenuById(@RequestParam int menuId)
	{
		return menuService.deleteMenuById(menuId);
	}
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int oldId,@RequestBody Menu newMenu)
	{
		return menuService.updateMenu(oldId, newMenu);
	}
	@GetMapping("/findAllMenu")
	public ResponseEntity<ResponseStructureList<Menu>> findAllMenu()
	{
		return menuService.findAllMenu();
	}
	@PutMapping("/addExistingFoodToExistingMenu")
	public ResponseEntity<ResponseStructure<Menu>> addExistingFoodToExistingMenu(@RequestParam int menuId,@RequestParam int foodId)
	{
		return menuService.addExistingFoodToExistingMenu(menuId, foodId);
	}
	@PutMapping("/addNewFoodToExistingMenu")
	public ResponseEntity<ResponseStructure<Menu>> addNewFoodToExistingMenu(@RequestParam int menuId,@RequestBody Food food)
	{
		return menuService.addNewFoodToExistingMenu(menuId, food);
	}

}
