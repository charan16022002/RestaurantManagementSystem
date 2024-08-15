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

import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.service.EmployeeService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	@GetMapping("/fetchEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(@RequestParam int employeeId)
	{
		return employeeService.fetchEmployeeById(employeeId);
	}
	@DeleteMapping("/deleteEmployeeById")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@RequestParam int employeeId)
	{
		return employeeService.deleteEmployeeById(employeeId);
	}
	@PutMapping("/updateEmployee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int oldId,@RequestBody Employee newEmployee)
	{
		return employeeService.updateEmployee(oldId, newEmployee);
	}
	@GetMapping("/findAllEmployee")
	public ResponseEntity<ResponseStructureList<Employee>> findAllEmployee()
	{
		return employeeService.findAllEmployee();
	}
}
