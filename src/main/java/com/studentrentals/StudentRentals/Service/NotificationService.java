package com.studentrentals.StudentRentals.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.BookingEntity;

import com.studentrentals.StudentRentals.Repository.NotificationRepository;



@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notifrep;
	
	
	
	public List<BookingEntity> getAllBooking(){
		return notifrep.findAll();
	}	
	
	

}
