package com.studentrentals.StudentRentals.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblreservation")
public class ReservationEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reservationid")
	private int reservationid;
	
	@Column(name="reservationDate")
	private String reservationDate;
	
	@Column(name="paymentStatus")
	private String paymentStatus;
	
	@Column(name="status")
	private String status;

	public ReservationEntity() {
		super();
	}

	public ReservationEntity(int reservationid, String reservationDate, String paymentStatus, String status) {
		super();
		this.reservationid = reservationid;
		this.reservationDate = reservationDate;
		this.paymentStatus = paymentStatus;
		this.status = status;
	}

	public int getReservationid() {
		return reservationid;
	}

	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	


}
