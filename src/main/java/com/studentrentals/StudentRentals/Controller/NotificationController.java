package com.studentrentals.StudentRentals.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;
import com.studentrentals.StudentRentals.Service.NotificationService;
import com.studentrentals.StudentRentals.Service.PaymentService;

@RestController
@RequestMapping("/notification")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class NotificationController {
	
	@Autowired
	NotificationService notifserv;
	
	@Autowired
	PaymentService payserv;
	
//	@GetMapping("/payment/{paymentId}")
//    public PaymentEntity getPaymentById(@PathVariable int paymentId) {
//        return notifserv.getPaymentById(paymentId);
//    }
	
	@GetMapping("/notificationPayment")
	public ResponseEntity<List<PaymentEntity>> getAllPayment() {
	    List<PaymentEntity> payments = notifserv.getAllPayment();
	    for (PaymentEntity payment : payments) {
	        payment.setStatus(payserv.paymentStatus(payment.getPaymentId()));
	    }

	    return ResponseEntity.ok().body(payments);
	}

	

}
