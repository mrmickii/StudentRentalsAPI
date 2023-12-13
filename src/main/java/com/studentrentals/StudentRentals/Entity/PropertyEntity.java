package com.studentrentals.StudentRentals.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="tblproperty")
public class PropertyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="propertyid")
	private int propid;
	
	@Column(name="name")
	private String name;
	
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

	@Lob
    @Column(name = "images")
    private byte[] images;
	
	public PropertyEntity() {
		super();
	}

	public PropertyEntity(String name, String address, int price, String type, int size, int numbeds, byte[] images) {
		super();
		this.name = name;
		this.address = address;
		this.price = price;
		this.type = type;
		this.size = size;
		this.numbeds = numbeds;
		this.images = images;
	}

	public int getPropid() {
		return propid;
	}

	public void setPropid(int propid) {
		this.propid = propid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public byte[] getImage() {
		return images;
	}

	public void setImage(byte[] images) {
		this.images = images;
	}	
}
