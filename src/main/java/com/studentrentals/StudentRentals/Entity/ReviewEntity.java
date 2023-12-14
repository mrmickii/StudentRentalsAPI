package com.studentrentals.StudentRentals.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblfeedback")
public class ReviewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reviewid")
    private int reviewid;
	
	@Column(name="description")
    private String description;

	@Column(name="timestamp")
    private Date timestamp;

	public ReviewEntity() {
		super();
	}

	public ReviewEntity(int reviewid, String description, Date timestamp) {
		super();
		this.reviewid = reviewid;
		this.description = description;
		this.timestamp = timestamp;
	}

	public int getId() {
		return reviewid;
	}

	public void setId(int reviewid) {
		this.reviewid = reviewid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
