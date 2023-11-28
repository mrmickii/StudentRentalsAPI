package com.studentrentals.StudentRentals.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentrentals.StudentRentals.Entity.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

}
