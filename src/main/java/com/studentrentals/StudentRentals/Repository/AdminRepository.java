package com.studentrentals.StudentRentals.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentrentals.StudentRentals.Entity.AdminEntity;



public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

    AdminEntity findByAdminUser(String adminUser);
}


