package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.AddressDao;
import com.qsp.restaurant_management_system.dto.Address;
import com.qsp.restaurant_management_system.exception.AddressIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	@Autowired
	ResponseStructure<Address> responseStructure;
	@Autowired
	ResponseStructureList<Address> responseStructureList;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully address inserted into DB");
		responseStructure.setData(addressDao.saveAddress(address));
		// return responseStructure;
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully address fetched from DB");
			responseStructure.setData(addressDao.fetchAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		Address address = addressDao.fetchAddressById(addressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully address deleted from DB");
			responseStructure.setData(addressDao.deleteAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address newAddress, int oldId) {
		Address address = addressDao.fetchAddressById(oldId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully address updated into DB");
			responseStructure.setData(addressDao.updateAddress(newAddress, oldId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Address>> findAllAddress() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all address fetched from DB");
		responseStructureList.setData(addressDao.findAllAddress());
		return new ResponseEntity<ResponseStructureList<Address>>(responseStructureList, HttpStatus.OK);

	}
}
