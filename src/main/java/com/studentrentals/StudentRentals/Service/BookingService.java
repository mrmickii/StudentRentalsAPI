package com.studentrentals.StudentRentals.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.BookingEntity;
import com.studentrentals.StudentRentals.Repository.BookingRepository;


@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookrep;
	
	//Create
	public BookingEntity insert(BookingEntity booking) {
		return bookrep.save(booking);
	}
	
	//GetAll
	public List<BookingEntity> getAllBooking(){
		return bookrep.findAll();
	}
	
	//Update
	@SuppressWarnings("finally")
	public BookingEntity update(int bookingid,BookingEntity newbooking){
		
		BookingEntity booking = new BookingEntity();
		try {
			booking = bookrep.findById(bookingid).get();
			
			booking.setFirstName(newbooking.getFirstName());
			booking.setMiddleName(newbooking.getMiddleName());
			booking.setLastName(newbooking.getLastName());
			booking.setDateBirth(newbooking.getDateBirth());
			booking.setEmail(newbooking.getEmail());
			booking.setNumber(newbooking.getNumber());
			booking.setSchool(newbooking.getSchool());
			
		}catch(NoSuchElementException e){
			throw new NoSuchElementException("Booking " +bookingid+ " does not  exist!");
		}finally {
			return bookrep.save(booking);
		}
		
	}
	
	//Delete
	public String delete(int bookingid) {
		String msg = "";
		
		if(bookrep.findById(bookingid) != null) {
			bookrep.deleteById(bookingid);
			msg = "Booking " +bookingid+ " is successfully deleted";
		}else {
			msg = "Booking " +bookingid+ " does not exist"; 
		}
		return msg;
		
		
	}

}
