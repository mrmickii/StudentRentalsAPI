package com.studentrentals.StudentRentals.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.ReviewEntity;
import com.studentrentals.StudentRentals.Repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository revrep;
	
	public ReviewEntity insertFeedback(ReviewEntity review) {
		return revrep.save(review);
	}
	
	public List<ReviewEntity> getAllFeedback(){
		return revrep.findAll();
	}
	
	@SuppressWarnings("finally")
	public ReviewEntity updateFeedback(int reviewid, ReviewEntity newreview){
		
		ReviewEntity review = new ReviewEntity();
		
		try {
			review = revrep.findById(reviewid).get();
			review.setDescription(newreview.getDescription());
			review.setTimestamp(newreview.getTimestamp());
		}catch(NoSuchElementException e){
			throw new NoSuchElementException("FeedBack " +reviewid+ " does not  exist!");
		}finally {
			return revrep.save(review);
		}
		
	}
	
	public String delete(int reviewid) {
		String msg = " ";
		
		if(revrep.findById(reviewid) != null) {
			revrep.deleteById(reviewid);
			msg = "FeedBack " +reviewid+ " is successfully deleted";
		}else {
			msg = "FeedBack " +reviewid+ " does not exist"; 
		}
		return msg;
		
	}
	
	
	

}
