package com.studentrentals.StudentRentals.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;

import com.studentrentals.StudentRentals.Repository.PaymentRepository;


@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository payrepo;
	
	//Create new payment
	public PaymentEntity insertPayment(PaymentEntity payment) {
		return payrepo.save(payment);
	}
	
	//Get all payment info
	public List<PaymentEntity> getAllPayment(){
		return payrepo.findAll();
	}
	
	//Update payment
	@SuppressWarnings("finally")
	public PaymentEntity updatePayment(int paymentid, PaymentEntity newpayment) {
		
		PaymentEntity payment = new PaymentEntity();
		
		try {
			payment = payrepo.findById(paymentid).get();
			
			payment.setPaymentMethod(newpayment.getPaymentMethod());
			payment.setAmount(newpayment.getAmount());
			payment.setStatus(newpayment.isStatus());
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException("Payment " +paymentid+ " does not  exist!");
		}finally {
			return payrepo.save(payment);
		}
	}
	
	//Delete payment
	public String deletePayment(int paymentid) {
		String msg = "";
		
		if(payrepo.findById(paymentid) != null) {
			payrepo.deleteById(paymentid);
			msg = "Payment " +paymentid+ " is successfully deleted";
		}else {
			msg = "Payment " +paymentid+ " does not exist"; 
		}
		return msg;
	}
	
	public boolean paymentStatus(int paymentid) {
	    try {
	        PaymentEntity payment = payrepo.findById(paymentid).orElseThrow(() ->
	            new NoSuchElementException("Payment " + paymentid + " does not exist!")
	        );

	       
	        return payment.isStatus();
	    } catch (NoSuchElementException e) {
	        
	        throw e;
	    }
	}
	
	
	
}
