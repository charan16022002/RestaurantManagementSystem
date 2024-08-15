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

import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.service.BranchService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;
@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch)
	{
		return branchService.saveBranch(branch);
	}
	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId)
	{
		return branchService.fetchBranchById(branchId);
	}
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId)
	{
		return branchService.deleteBranchById(branchId);
	}
	@PutMapping("/updateBranch")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestParam int oldId,@RequestBody Branch newBranch)
	{
		return branchService.updateBranch(oldId, newBranch);
	}
	@GetMapping("/findAllBranches")
	public ResponseEntity<ResponseStructureList<Branch>> findAllBranches()
	{
		return branchService.findAllBranches();
	}
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(@RequestParam int branchId,@RequestParam int addressId)
	{
		return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}
	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(@RequestParam int branchId,@RequestBody Address address)
	{
	return branchService.addNewAddressToExistingBranch(branchId, address);
	}
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(@RequestParam int branchId,@RequestParam int managerId)
	{
	return branchService.addExistingManagerToExistingBranch(branchId, managerId);
	}
	@PutMapping("/addNewManagerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(@RequestParam int branchId,@RequestBody Manager manager)
	{
		return branchService.addNewManagerToExistingBranch(branchId, manager);
	}
	@PutMapping("/addExistingMenuToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingMenuToExistingBranch(@RequestParam int branchId,@RequestParam int menuId)
	{
		return branchService.addExistingMenuToExistingBranch(branchId, menuId);
	}
	@PutMapping("/addNewMenuToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewMenuToExistingBranch(@RequestParam int branchId,@RequestBody Menu menu)
	{
		return branchService.addNewMenuToExistingBranch(branchId, menu);
	}
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(@RequestParam int branchId,@RequestParam int employeeId)
	{
		return branchService.addExistingEmployeeToExistingBranch(branchId, employeeId);
		
	}
	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(@RequestParam int branchId,@RequestBody Employee employee)
	{
		return branchService.addNewEmployeeToExistingBranch(branchId, employee);
	}
	@PutMapping("/addExistingCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(@RequestParam int branchId,@RequestParam int customerId)
	{
		return branchService.addExistingCustomerToExistingBranch(branchId, customerId);
		
	}
	@PutMapping("/addNewCustomerToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(@RequestParam int branchId,@RequestBody Customer customer)
	{
		return branchService.addNewCustomerToExistingBranch(branchId, customer);
	}
}
