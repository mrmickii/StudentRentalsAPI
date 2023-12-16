package com.studentrentals.StudentRentals.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import com.studentrentals.StudentRentals.Entity.PaymentEntity;
=======

import com.studentrentals.StudentRentals.Entity.BookingEntity;

>>>>>>> 9677971aab3aa7dbd5d4cc6331ee6e08e842ff8c
import com.studentrentals.StudentRentals.Repository.NotificationRepository;

@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notifrep;
	
	
<<<<<<< HEAD
	public PaymentEntity getPaymentById(int paymentId) {
        java.util.Optional<PaymentEntity> payment = notifrep.findById(paymentId);
        return payment.orElse(null);
    }
	
	public List<PaymentEntity> getAllPayment() {
	    List<PaymentEntity> payments = payserv.getAllPayment();
	    for (PaymentEntity payment : payments) {
	        payment.setStatus(payserv.paymentStatus(payment.getPaymentId()));
	    }
	    
	    return payments;
	}
=======
	
	public List<BookingEntity> getAllBooking(){
		return notifrep.findAll();
	}	
	
	

>>>>>>> 9677971aab3aa7dbd5d4cc6331ee6e08e842ff8c
}
