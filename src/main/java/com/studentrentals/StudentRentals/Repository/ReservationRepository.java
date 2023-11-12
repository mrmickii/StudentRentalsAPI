package com.studentrentals.StudentRentals.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentrentals.StudentRentals.Entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
	
	List<ReservationEntity>findByStatus(String status);

}
