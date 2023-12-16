package com.studentrentals.StudentRentals.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.studentrentals.StudentRentals.Entity.BookingEntity;
import com.studentrentals.StudentRentals.Service.NotificationService;


@RestController
@RequestMapping("/notification")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class NotificationController {
	
	@Autowired
	NotificationService notifserv;
	
	
	
	@GetMapping("/paymentNotification")
	public List<BookingEntity>getAllBooking(){
		return notifserv.getAllBooking();
	}

	

}
