package com.studentrentals.StudentRentals.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;
import com.studentrentals.StudentRentals.Service.NotificationService;
import com.studentrentals.StudentRentals.Service.PaymentService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	NotificationService notifserv;
	
	@Autowired
	PaymentService payserv;
	
	@GetMapping("/payment/{paymentId}")
    public PaymentEntity getPaymentById(@PathVariable int paymentId) {
        return notifserv.getPaymentById(paymentId);
    }
	
	@GetMapping("/allpayment")
	public String getAllPayment() {
	    List<PaymentEntity> payments = notifserv.getAllPayment();
	    for (PaymentEntity payment : payments) {
	        payment.setStatus(payserv.paymentStatus(payment.getPaymentId()));
	    }
	    
	    return payments.toString();

	}

	

}
