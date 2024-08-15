package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.ManagerDao;
import com.qsp.restaurant_management_system.dto.Manager;
import com.qsp.restaurant_management_system.exception.ManagerIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;
	@Autowired
	ResponseStructure<Manager> responseStructure;
	@Autowired
	ResponseStructureList<Manager> responseStructureList;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully manager inserted into DB");
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully manager fetched from DB");
			responseStructure.setData(managerDao.fetchManagerById(managerId));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully manager deleted from DB");
			responseStructure.setData(managerDao.deleteManagerById(managerId));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> updateManager(int oldId, Manager newManager) {
		Manager manager = managerDao.fetchManagerById(oldId);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully manager updated from DB");
			responseStructure.setData(managerDao.updateManager(oldId, newManager));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Manager>> findAllManagers() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all managers fetched from DB");
		responseStructureList.setData(managerDao.findAllManagers());
		return new ResponseEntity<ResponseStructureList<Manager>>(responseStructureList, HttpStatus.OK);
	}
}
