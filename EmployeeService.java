package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.EmployeeDao;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.exception.EmployeeIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	ResponseStructure<Employee> responseStructure;
	@Autowired
	ResponseStructureList<Employee> responseStructureList;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully employee inserted into DB");
		responseStructure.setData(employeeDao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Employee>> fetchEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully employee fetched from DB");
			responseStructure.setData(employeeDao.fetchEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(int employeeId) {
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		if (employee != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully employee deleted from DB");
			responseStructure.setData(employeeDao.deleteEmployeeById(employeeId));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int oldId, Employee newEmployee) {
		Employee employee = employeeDao.fetchEmployeeById(oldId);
		if (employee != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully employee updated into DB");
			responseStructure.setData(employeeDao.updateEmployee(oldId, newEmployee));
			return new ResponseEntity<ResponseStructure<Employee>>(responseStructure, HttpStatus.OK);
		} else {
			throw new EmployeeIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Employee>> findAllEmployee() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully fetched all employees from DB");
		responseStructureList.setData(employeeDao.findAllEmployee());
		return new ResponseEntity<ResponseStructureList<Employee>>(responseStructureList, HttpStatus.OK);
	}

}
