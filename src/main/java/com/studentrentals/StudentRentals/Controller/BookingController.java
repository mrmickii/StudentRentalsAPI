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
@RequestMapping("/reservation")
public class BookingController {
	
	@Autowired
	BookingService reserv;
	
	//Create
	@PostMapping("/insertReserv")
	public BookingEntity insertReserv(@RequestBody BookingEntity resvartion) {
		return reserv.insert(resvartion);
	}
	
	//Read
	@GetMapping("/getAllReserv")
	public List<BookingEntity>getAllReservation(){
		return reserv.getAllReservation();
	}
	
	//Update
    @PutMapping("/updateReserv")
    public BookingEntity updateReserv(@RequestParam int reservationid, @RequestBody BookingEntity res) {
    	return reserv.update(reservationid, res);
    }
    
    //Delete
  	@DeleteMapping("/deleteProperty/{propid}")
  	public String deleteReserv(@PathVariable int reservationid) {
  		return reserv.delete(reservationid);
  	}

}
