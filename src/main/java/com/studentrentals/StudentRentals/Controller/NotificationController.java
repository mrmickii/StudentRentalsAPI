package com.studentrentals.StudentRentals.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;
import com.studentrentals.StudentRentals.Service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	NotificationService notifserv;
	
	@GetMapping("/payment/{paymentId}")
    public PaymentEntity getPaymentById(@PathVariable int paymentId) {
        return notifserv.getPaymentById(paymentId);
    }
	
	@GetMapping("/checkPaymentStatus/{paymentId}")
    public String checkPaymentStatus(@PathVariable int paymentId) {
        try {
            PaymentEntity payment = notifserv.getPaymentById(paymentId);

            if (payment != null) {
                boolean status = notifserv.checkPaymentStatus(paymentId);
                return "Payment " + paymentId + " status: " + (status ? "Paid" : "Unpaid") + "\n" + payment.toString();
            } else {
                return "Payment " + paymentId + " not found";
            }

        } catch (Exception e) {
            
            return "Error checking payment status for Payment " + paymentId;
        }
        
    }
	

}
