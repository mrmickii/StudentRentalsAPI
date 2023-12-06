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
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
    private String description;
    
	@Column(name="rating")
    private int rating;
    
	@Column(name="timestamp")
    private Date timestamp;

	public ReviewEntity() {
		super();
	}

	public ReviewEntity(int reviewid, String title, String description, int rating, Date timestamp) {
		super();
		this.reviewid = reviewid;
		this.title = title;
		this.description = description;
		this.rating = rating;
		this.timestamp = timestamp;
	}

	public int getId() {
		return reviewid;
	}

	public void setId(int reviewid) {
		this.reviewid = reviewid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
