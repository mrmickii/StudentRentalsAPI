package com.studentrentals.StudentRentals.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;
import com.studentrentals.StudentRentals.Repository.NotificationRepository;



@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notifrep;
	
	@Autowired
	PaymentService payserv;
	
	public PaymentEntity getPaymentById(int paymentId) {
        java.util.Optional<PaymentEntity> payment = notifrep.findById(paymentId);
        return payment.orElse(null);
    }
	
	public List<PaymentEntity> getAllPayment() {
	    List<PaymentEntity> payments = payserv.getAllPayment();
	    for (PaymentEntity payment : payments) {
	        payment.setStatus(payserv.paymentStatus(payment.getPaymentId()));
	    }
	    System.out.println();
	    return payments;
	}
	
	
	

}
