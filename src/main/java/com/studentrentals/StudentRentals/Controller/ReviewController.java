package com.studentrentals.StudentRentals.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.studentrentals.StudentRentals.Entity.ReviewEntity;
import com.studentrentals.StudentRentals.Service.ReviewService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "http://localhost:5173")
public class ReviewController {
	
	@Autowired
	ReviewService revserv;
	
	@PostMapping("/insertFeedback")
	public ReviewEntity insert(@RequestBody ReviewEntity reviews) {
		return revserv.insertFeedback(reviews);
	}
	
	@GetMapping("")
	public List<ReviewEntity> getAllReviews(){
		return revserv.getAllFeedback();
	}
	
	@PutMapping("/updateReviews")
    public ReviewEntity update(@RequestParam int reviewid, @RequestBody ReviewEntity reviews) {
    	return revserv.updateFeedback(reviewid, reviews);
    }
	
	@DeleteMapping("/deleteReviews/{reviewid}")
  	public String delete(@PathVariable int reviewid) {
  		return revserv.delete(reviewid);
  	}
}
