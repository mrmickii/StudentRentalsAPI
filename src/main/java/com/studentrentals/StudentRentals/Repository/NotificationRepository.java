package com.studentrentals.StudentRentals.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.studentrentals.StudentRentals.Entity.PaymentEntity;


public interface NotificationRepository extends JpaRepository<PaymentEntity, Integer> {
	
}
