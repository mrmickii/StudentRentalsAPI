package com.studentrentals.StudentRentals.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentrentals.StudentRentals.Entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer>{

}
