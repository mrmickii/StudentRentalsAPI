package com.studentrentals.StudentRentals.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentrentals.StudentRentals.Entity.BookingEntity;
import com.studentrentals.StudentRentals.Service.BookingService;

@Controller 
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookserv;
	
	//Create
	@PostMapping("/insertBooking")
	public BookingEntity insert(@RequestBody BookingEntity booking) {
		return bookserv.insert(booking);
	}
	
	//Read
	@GetMapping("/getAllBooking")
	public List<BookingEntity>getAllBooking(){
		return bookserv.getAllBooking();
	}
	
	//Update
    @PutMapping("/updateBooking")
    public BookingEntity update(@RequestParam int bookingid, @RequestBody BookingEntity booking) {
    	return bookserv.update(bookingid, booking);
    }
    
    //Delete
  	@DeleteMapping("/deleteBooking/{bookingid}")
  	public String delete(@PathVariable int bookingid) {
  		return bookserv.delete(bookingid);
  	}

}
