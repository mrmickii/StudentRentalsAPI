package com.studentrentals.StudentRentals.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;

import com.studentrentals.StudentRentals.Repository.PaymentRepository;


@Service
@CrossOrigin
public class PaymentService {
    
    @Autowired
    PaymentRepository payrepo;
    
    public PaymentEntity insertPayment(PaymentEntity payment) {
        payment.setSelectedPaymentOption(payment.getSelectedPaymentOption());
        PaymentEntity savedPayment = payrepo.save(payment);
        savedPayment.setStatusDone(); // Set status to "done" after saving
        return savedPayment;
    }

    // Get all payment info
    public List<PaymentEntity> getAllPayment(){
        return payrepo.findAll();
    }
    
    // Update payment status
    public boolean updatePaymentStatus(int paymentid) {
        try {
            PaymentEntity payment = payrepo.findById(paymentid).orElseThrow(() ->
                new NoSuchElementException("Payment " + paymentid + " does not exist!")
            );

            payment.setStatusDone();
            payrepo.save(payment);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    // Delete payment
    public String deletePayment(int paymentid) {
        String msg = "";
        
        if(payrepo.findById(paymentid) != null) {
            payrepo.deleteById(paymentid);
            msg = "Payment " +paymentid+ " is successfully deleted	";
        } else {
            msg = "Payment " +paymentid+ " does not exist"; 
        }
        return msg;
    }
    
    public boolean paymentStatus(int paymentid) {
        try {
            PaymentEntity payment = payrepo.findById(paymentid).orElseThrow(() ->
                new NoSuchElementException("Payment " + paymentid + " does not exist!")
            );

            return payment.getStatus();
        } catch (NoSuchElementException e) {
            throw e;
        }
    }
}
