package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.dto.Restaurant;
import com.qsp.restaurant_management_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	@Autowired
	AddressDao addressDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	MenuDao menuDao;
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	CustomerDao customerDao;
	
	public Branch saveBranch(Branch branch)
	{
		return branchRepo.save(branch);
	}
	public Branch fetchBranchById(int branchId)
	{
		
		Optional<Branch> branch= branchRepo.findById(branchId);
		if(branch.isEmpty())
		{
			return null;
		}
		return branch.get();
	}
	public Branch deleteBranchById(int branchId)
	{
		Branch branch=fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	public Branch updateBranch(int oldId,Branch newBranch)
	{
		newBranch.setBranchId(oldId);
		return branchRepo.save(newBranch);
	}
	public List<Branch> findAllBranches()
	{
		return branchRepo.findAll();
	}
	public Branch addExistingAddressToExistingBranch(int branchId,int addressId)
	{
		Branch branch=fetchBranchById(branchId);
		Address address=addressDao.fetchAddressById(addressId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	public Branch addNewAddressToExistingBranch(int branchId,Address address)
	{
		Branch branch=fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addExistingManagerToExistingBranch(int branchId,int managerId)
	{
		Branch branch=fetchBranchById(branchId);
		Manager manager=managerDao.fetchManagerById(managerId);
		branch.setManager(manager);;
		return saveBranch(branch);
	}
	public Branch addNewManagerToExistingBranch(int branchId,Manager manager)
	{
		Branch branch=fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
	public Branch addExistingMenuToExistingBranch(int branchId,int menuId)
	{
		Branch branch=fetchBranchById(branchId);
		Menu menu=menuDao.fetchMenuById(menuId);
		branch.setMenu(menu);;
		return saveBranch(branch);
	}
	public Branch addNewMenuToExistingBranch(int branchId,Menu menu)
	{
		Branch branch=fetchBranchById(branchId);
		branch.setMenu(menu);
		return saveBranch(branch);
	}
	
	public Branch addExistingEmployeeToExistingBranch(int branchId,int employeeId)
	{
		Branch branch=fetchBranchById(branchId);
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		List<Employee> list=branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
		
	}
	public Branch addNewEmployeeToExistingBranch(int branchId,Employee employee)
	{
		Branch branch=fetchBranchById(branchId);
		List<Employee> list=branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	public Branch addExistingCustomerToExistingBranch(int branchId,int customerId)
	{
		Branch branch=fetchBranchById(branchId);
		Customer customer=customerDao.fetchCustomerById(customerId);
		List<Customer> list=branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
		
	}
	public Branch addNewCustomerToExistingBranch(int branchId,Customer customer)
	{
		Branch branch=fetchBranchById(branchId);
		List<Customer> list=branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}

}
