package com.qsp.restaurant_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.restaurant_management_system.dao.PaymentDao;
import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.exception.PaymentIdNotFound;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@Service
public class PaymentService {

	@Autowired
	PaymentDao paymentDao;
	@Autowired
	ResponseStructure<Payment> responseStructure;
	@Autowired
	ResponseStructureList<Payment> responseStructureList;

	public ResponseEntity<ResponseStructure<Payment>> savePayment(Payment payment) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("sucessfully payment inserted into DB");
		responseStructure.setData(paymentDao.savePayment(payment));
		return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("sucessfully payment fetched from DB");
			responseStructure.setData(paymentDao.fetchPaymentById(paymentId));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(int paymentId) {
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully payment deleted from DB");
			responseStructure.setData(paymentDao.deletePaymentById(paymentId));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Payment>> updatePayment(int oldId, Payment newPayment) {
		Payment payment = paymentDao.fetchPaymentById(oldId);
		if (payment != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("sucessfully payment updated into DB");
			responseStructure.setData(paymentDao.updatePayment(oldId, newPayment));
			return new ResponseEntity<ResponseStructure<Payment>>(responseStructure, HttpStatus.OK);
		} else {
			throw new PaymentIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructureList<Payment>> findAllPayment() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("sucessfully all payments fetched from DB");
		responseStructureList.setData(paymentDao.findAllPayment());
		return new ResponseEntity<ResponseStructureList<Payment>>(responseStructureList, HttpStatus.OK);
	}
}
