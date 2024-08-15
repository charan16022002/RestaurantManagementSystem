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
import com.qsp.restaurant_management_system.service.AddressService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;
@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId)
	{
		return addressService.fetchAddressById(addressId);
	}
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId)
	{
	
		return addressService.deleteAddressById(addressId);
	}
	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address newAddress,@RequestParam int oldId)
	{
		
		return addressService.updateAddress(newAddress, oldId);
	}
	@GetMapping("/findAllAddress")
	public ResponseEntity<ResponseStructureList<Address>> findAllAddress()
	{
		return addressService.findAllAddress();
	}
}
