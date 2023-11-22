package com.studentrentals.StudentRentals.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.ReservationEntity;
import com.studentrentals.StudentRentals.Repository.ReservationRepository;

@Service
public class ReservationService {
	
	
	@Autowired
	ReservationRepository reservationRep;
	
	public ReservationEntity insert(ReservationEntity reserv) {
		return reservationRep.save(reserv);
	}
	
	public List<ReservationEntity> getAllReservation(){
		return reservationRep.findAll();
	}
	
	@SuppressWarnings("finally")
	public ReservationEntity update(int reservationid, ReservationEntity newresv) {
		
		ReservationEntity reserv = new ReservationEntity();
		
		try {
			reserv = reservationRep.findById(reservationid).get();
			
			reserv.setPaymentStatus(newresv.getPaymentStatus());
			reserv.setReservationDate(newresv.getReservationDate());
			reserv.setStatus(newresv.getStatus());
			
		}catch(NoSuchElementException e){
			throw new NoSuchElementException("Reservation " +reservationid+ " does not exist!");
		}finally {
			return reservationRep.save(reserv);
		}
	 
	}
	
	public String delete(int reservationid) {
        String msg = "";
		
		if(reservationRep.findById(reservationid) != null) {
			reservationRep.deleteById(reservationid);
			msg = "Reservation " +reservationid+ " is successfully deleted";
		}else {
			msg = "Reservation " +reservationid+ " does not exists";
		}
		return msg;
	}

}
