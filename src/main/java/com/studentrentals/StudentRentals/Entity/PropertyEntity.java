package com.studentrentals.StudentRentals.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblreservation")
public class PropertyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="propertyid")
	private int propid;
	@Column(name="address")
	private String address;
	@Column(name="price")
	private int price;
	@Column(name="type")
	private String type;
	@Column(name="size")
	private int size;
	@Column(name="numberofbedrooms")
	private int numbeds;
	
	public PropertyEntity() {
		super();
	}

	public int getPropid() {
		return propid;
	}

	public void setPropid(int propid) {
		this.propid = propid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNumbeds() {
		return numbeds;
	}

	public void setNumbeds(int numbeds) {
		this.numbeds = numbeds;
	}
	
}
