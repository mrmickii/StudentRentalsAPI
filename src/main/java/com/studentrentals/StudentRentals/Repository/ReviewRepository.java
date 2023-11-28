package com.studentrentals.StudentRentals.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentrentals.StudentRentals.Entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
	
	

}
