package com.qsp.restaurant_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.AddressDao;
import com.qsp.restaurant_management_system.dao.BranchDao;
import com.qsp.restaurant_management_system.dao.CustomerDao;
import com.qsp.restaurant_management_system.dao.EmployeeDao;
import com.qsp.restaurant_management_system.dao.ManagerDao;
import com.qsp.restaurant_management_system.dao.MenuDao;
import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.dto.Branch;
import com.qsp.restaurant_management_system.dto.Customer;
import com.qsp.restaurant_management_system.dto.Employee;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.dto.Menu;
import com.qsp.restaurant_management_system.exception.AddressAlreadyMapped;
import com.qsp.restaurant_management_system.exception.AddressIdNotFound;
import com.qsp.restaurant_management_system.exception.BranchIdNotFound;
import com.qsp.restaurant_management_system.exception.CustomerAlreadyMapped;
import com.qsp.restaurant_management_system.exception.CustomerIdNotFound;
import com.qsp.restaurant_management_system.exception.EmployeeAlreadyMapped;
import com.qsp.restaurant_management_system.exception.EmployeeIdNotFound;
import com.qsp.restaurant_management_system.exception.ManagerAlreadyMappedCannotMapTwice;
import com.qsp.restaurant_management_system.exception.ManagerIdNotFound;
import com.qsp.restaurant_management_system.exception.MenuAlreadyMapped;
import com.qsp.restaurant_management_system.exception.MenuIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
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
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructureList<Branch> responseStructureList;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully branch inserted into DB");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully branch fetched from DB");
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully branch deleted from DB");
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int oldId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully branch updated  into DB");
			responseStructure.setData(branchDao.updateBranch(oldId, newBranch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructureList<Branch>> findAllBranches() {
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("sucessfully fetched All Branches From DB");
		responseStructureList.setData(branchDao.findAllBranches());
		return new ResponseEntity<ResponseStructureList<Branch>>(responseStructureList, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingAddressToExistingBranch(int branchId, int addressId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		Address address2=branch.getAddress();
		if(address2==null)
		{
			if (branch != null && address != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("sucessfully added Existing Address To Existing Branch into DB");
				responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else if (branch == null) {
				throw new BranchIdNotFound();
			} else {
				throw new AddressIdNotFound();
			}
		}
		else {
			throw new AddressAlreadyMapped();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> addNewAddressToExistingBranch(int branchId, Address address) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added New Address To Existing Branch into DB");
			responseStructure.setData(branchDao.addNewAddressToExistingBranch(branchId, address));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingManagerToExistingBranch(int branchId, int managerId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Manager manager = managerDao.fetchManagerById(managerId);
		Manager manager1=branch.getManager();
		if(manager1==null)
		{
			if (branch != null && manager != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("sucessfully added Existing Manager To Existing Branch into DB");
				responseStructure.setData(branchDao.addExistingManagerToExistingBranch(branchId, managerId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else if (branch == null) {
				throw new BranchIdNotFound();
			} else {
				throw new ManagerIdNotFound();
			}
		}
		else {
			throw new ManagerAlreadyMappedCannotMapTwice();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewManagerToExistingBranch(int branchId, Manager manager) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added New Manager To Existing Branch into DB");
			responseStructure.setData(branchDao.addNewManagerToExistingBranch(branchId, manager));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingMenuToExistingBranch(int branchId, int menuId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Menu menu = menuDao.fetchMenuById(menuId);
		Menu menu1=branch.getMenu();
		if(menu1==null)
		{
			if (branch != null && menu != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("sucessfully added Existing Mneu To Existing Branch into DB");
				responseStructure.setData(branchDao.addExistingMenuToExistingBranch(branchId, menuId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
			} else if (branch == null) {
				throw new BranchIdNotFound();
			} else {
				throw new MenuIdNotFound();
			}
		}
		else {
			throw new MenuAlreadyMapped();
		}
		
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewMenuToExistingBranch(int branchId, Menu menu) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added New Mneu To Existing Branch into DB");
			responseStructure.setData(branchDao.addNewMenuToExistingBranch(branchId, menu));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingEmployeeToExistingBranch(int branchId, int employeeId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Employee employee = employeeDao.fetchEmployeeById(employeeId);
		List<Branch> branches=branchDao.findAllBranches();
		for(Branch branch2:branches)
		{
			List<Employee> employees=branch2.getEmployee();
			for(Employee employee1:employees)
			{
				if(employee1.getEmployeeId()==employeeId)
				{
					throw new EmployeeAlreadyMapped();

				}
			}
		}
		if (branch != null && employee != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added Existing Employee To Existing Branch into DB");
			responseStructure.setData(branchDao.addExistingEmployeeToExistingBranch(branchId, employeeId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else if (branch == null) {
			throw new BranchIdNotFound();
		} else {
			throw new EmployeeIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> addNewEmployeeToExistingBranch(int branchId, Employee employee) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added New Employee To Existing Branch into DB");
			responseStructure.setData(branchDao.addNewEmployeeToExistingBranch(branchId, employee));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingCustomerToExistingBranch(int branchId, int customerId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Customer customer = customerDao.fetchCustomerById(customerId);
		List<Branch> branches=branchDao.findAllBranches();
		for(Branch branch2:branches)
		{
			List<Customer> customers=branch2.getCustomer();
			for(Customer  customer1:customers)
			{
				if(customer1.getCustomerId()==customerId)
				{
					throw new CustomerAlreadyMapped();

				}
			}
		}
		if (branch != null && customer != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added Existing Customer To Existing Branch into DB");
			responseStructure.setData(branchDao.addExistingCustomerToExistingBranch(branchId, customerId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else if (branch == null) {
			throw new BranchIdNotFound();
		} else {
			throw new CustomerIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Branch>> addNewCustomerToExistingBranch(int branchId, Customer customer) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added New Customer To Existing Branch into DB");
			responseStructure.setData(branchDao.addNewCustomerToExistingBranch(branchId, customer));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}
}
