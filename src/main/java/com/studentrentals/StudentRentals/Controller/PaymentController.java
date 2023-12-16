package com.studentrentals.StudentRentals.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/studentrentals")
@CrossOrigin
public class PaymentController {
    
    @Autowired
    PaymentService payserv;
    
    // Create payment
    @PostMapping("/insertPayment")
    public PaymentEntity insertPayment(@RequestBody PaymentEntity payment) {
        return payserv.insertPayment(payment);
    }

    // Read all payment info
    @GetMapping("/getAllPayment")
    public List<PaymentEntity> getAllPayment() {
        return payserv.getAllPayment();
    }

    // Update Payment Status
    @PutMapping("/updatePaymentStatus/{paymentid}")
    public ResponseEntity<String> updatePaymentStatus(@PathVariable int paymentid) {
        boolean success = payserv.updatePaymentStatus(paymentid);

        if (success) {
            return ResponseEntity.ok("Payment " + paymentid + " status updated to done");
        } else {
            return ResponseEntity.ok("Failed to update status for payment " + paymentid);
        }
    }

    // Delete
    @DeleteMapping("/deletePayment/{paymentid}")
    public String deletePayment(@PathVariable int paymentid) {
        return payserv.deletePayment(paymentid);
    }

    @GetMapping("/paymentStatus/{paymentid}")
    public ResponseEntity<String> checkPaymentStatus(@PathVariable int paymentid) {
        boolean success = payserv.paymentStatus(paymentid);

        if (success) {
            return ResponseEntity.ok("Payment " + paymentid + " is successful");
        } else {
            return ResponseEntity.ok("Payment " + paymentid + " is not successful");
        }
    }
}
