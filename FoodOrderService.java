package com.qsp.restaurant_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.FoodOrderDao;
import com.qsp.restaurant_management_system.dao.PaymentDao;
import com.qsp.restaurant_management_system.dto.FoodOrder;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.exception.FoodOrderIdNotFound;
import com.qsp.restaurant_management_system.exception.PaymentAlreadyExists;
import com.qsp.restaurant_management_system.exception.PaymentIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodOrderDao;
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	ResponseStructure<FoodOrder> responseStructure;
	@Autowired
	ResponseStructureList<FoodOrder> responseStructureList;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully foodOrder inserted into DB");
		responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> fetchFoodOrderById(int foodOrderId) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully foodOrder fetched from DB");
			responseStructure.setData(foodOrderDao.fetchFoodOrderById(foodOrderId));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrderById(int foodOrderId) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully foodOrder deleted from DB");
			responseStructure.setData(foodOrderDao.deleteFoodOrderById(foodOrderId));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(int oldId, FoodOrder newFoodOrder) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(oldId);
		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully foodOrder updated into DB");
			responseStructure.setData(foodOrderDao.updateFoodOrder(oldId, newFoodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<FoodOrder>> findAllFoodOrders() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all foodOrders fetched from DB");
		responseStructureList.setData(foodOrderDao.findAllFoodOrders());
		return new ResponseEntity<ResponseStructureList<FoodOrder>>(responseStructureList, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> addExistingPaymentToFoodOrder(int foodOrderId, int paymentId) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		Payment payment2=foodOrder.getPayment();
		if(payment2==null)
		{
			if (payment != null && foodOrder != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("sucessfully added Existing Payment To FoodOrder");
				responseStructure.setData(foodOrderDao.addExistingPaymentToFoodOrder(foodOrderId, paymentId));
				return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
			} else if (foodOrder == null) {
				throw new FoodOrderIdNotFound();
			} else {
				throw new PaymentIdNotFound();
			}
		}
		else {
			throw new PaymentAlreadyExists();
		}
		
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> addNewPaymentToExistingFoodOrder(int foodOrderId,
			Payment payment) {
		FoodOrder foodOrder = foodOrderDao.fetchFoodOrderById(foodOrderId);
		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully added new Payment To FoodOrder");
			responseStructure.setData(foodOrderDao.addNewPaymentToExistingFoodOrder(foodOrderId, payment));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFound();
		}
	}
}
