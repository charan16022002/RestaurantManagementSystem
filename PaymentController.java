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

import com.qsp.restaurant_management_system.dto.Payment;
import com.qsp.restaurant_management_system.service.PaymentService;
import com.qsp.restaurant_management_system.util.ResponseStructure;
import com.qsp.restaurant_management_system.util.ResponseStructureList;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	@PostMapping("/savePayment")
	public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}
	@GetMapping("/fetchPaymentById")
	public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}
	@DeleteMapping("/deletePaymentById")
	public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}
	@PutMapping("/updatePayment")
	public ResponseEntity<ResponseStructure<Payment>> updatePayment(@RequestParam int oldId,@RequestBody Payment newPayment) {
		return paymentService.updatePayment(oldId, newPayment);
	}
	@GetMapping("/findAllPayment")
	public ResponseEntity<ResponseStructureList<Payment>> findAllPayment() {
		return paymentService.findAllPayment();
	}
}
