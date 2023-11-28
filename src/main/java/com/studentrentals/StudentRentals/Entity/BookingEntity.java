package com.studentrentals.StudentRentals.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblbooking")
public class BookingEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookingid")
	private int bookingid;
	
	@Column(name="fname")
	private String firstName;
	
	@Column(name="mname")
	private String middleName;
	
	@Column(name="lname")
	private String lastName;
	
	@Column(name="dbirth")
	private String dateBirth;
	
	@Column(name="email")
	private String email;
	
	@Column(name="number")
	private String number;
	
	@Column(name="school")
	private String school;

	public BookingEntity() {
		super();
	}

	public BookingEntity(int bookingid, String firstName, String middleName, String lastName, String dateBirth,
			String email, String number, String school) {
		super();
		this.bookingid = bookingid;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.email = email;
		this.number = number;
		this.school = school;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	

	
}
