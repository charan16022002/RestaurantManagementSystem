package com.qsp.restaurant_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo employeeRepo;
	

	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	public Employee fetchEmployeeById(int employeeId)
	{
		Optional<Employee> employee=employeeRepo.findById(employeeId);
		if(employee.isEmpty())
		{
			return null;
		}
		return employee.get();
	}
	public Employee deleteEmployeeById(int employeeId)
	{
		Employee employee=fetchEmployeeById(employeeId);
		employeeRepo.delete(employee);
		return employee;
	}
	public Employee updateEmployee(int oldId,Employee newEmployee)
	{
		newEmployee.setEmployeeId(oldId);
		return employeeRepo.save(newEmployee);
	}
	public List<Employee> findAllEmployee()
	{
		return employeeRepo.findAll();
	}

}
