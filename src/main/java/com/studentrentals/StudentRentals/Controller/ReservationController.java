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

import com.studentrentals.StudentRentals.Entity.ReservationEntity;
import com.studentrentals.StudentRentals.Service.ReservationService;

@Controller 
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reserv;
	
	//Create
	@PostMapping("/insertReserv")
	public ReservationEntity insertReserv(@RequestBody ReservationEntity resvartion) {
		return reserv.insert(resvartion);
	}
	
	//Read
	@GetMapping("/getAllReserv")
	public List<ReservationEntity>getAllReservation(){
		return reserv.getAllReservation();
	}
	
	//Update
    @PutMapping("/updateReserv")
    public ReservationEntity updateReserv(@RequestParam int reservationid, @RequestBody ReservationEntity res) {
    	return reserv.update(reservationid, res);
    }
    
    //Delete
  	@DeleteMapping("/deleteProperty/{propid}")
  	public String deleteReserv(@PathVariable int reservationid) {
  		return reserv.delete(reservationid);
  	}

}
