package com.studentrentals.StudentRentals.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;
import com.studentrentals.StudentRentals.Service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService payserv;
	
	//Create payment
	@PostMapping("/insertPayment")
	public PaymentEntity inserPayment(@RequestBody PaymentEntity payment) {
		return payserv.insertPayment(payment);
	}
	
	//Read all payment info
	@GetMapping("/getAllPayment")
	public List<PaymentEntity> getAllPayment(){
		return payserv.getAllPayment();
	}
	
	//Update Payment
	@PutMapping("/updatePayment")
	public PaymentEntity updatePayment(@RequestParam int paymentid, @RequestBody PaymentEntity newpayment) {
		return payserv.updatePayment(paymentid, newpayment);
	}
	
	//Delete
	@DeleteMapping("/deletePayment/{paymentid}")
	public String deletePayment(@PathVariable int paymentid) {
		return payserv.deletePayment(paymentid);
	}
}
