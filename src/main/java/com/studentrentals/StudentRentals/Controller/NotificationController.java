package com.studentrentals.StudentRentals.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 9677971aab3aa7dbd5d4cc6331ee6e08e842ff8c
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import com.studentrentals.StudentRentals.Entity.PaymentEntity;
=======
import com.studentrentals.StudentRentals.Entity.BookingEntity;
>>>>>>> 9677971aab3aa7dbd5d4cc6331ee6e08e842ff8c
import com.studentrentals.StudentRentals.Service.NotificationService;


@RestController
@RequestMapping("/studentrentals")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class NotificationController {
<<<<<<< HEAD

    @Autowired
    NotificationService notifserv;
=======
	
	@Autowired
	NotificationService notifserv;
	
	
	
	@GetMapping("/paymentNotification")
	public List<BookingEntity>getAllBooking(){
		return notifserv.getAllBooking();
	}
>>>>>>> 9677971aab3aa7dbd5d4cc6331ee6e08e842ff8c

    @Autowired
    PaymentService payserv;

    @GetMapping("/notificationPayment")
    public ResponseEntity<List<PaymentEntity>> getAllPayment() {
        try {
            List<PaymentEntity> payments = notifserv.getAllPayment();
            return ResponseEntity.ok().body(payments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}