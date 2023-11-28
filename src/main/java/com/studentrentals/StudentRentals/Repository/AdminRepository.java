package com.studentrentals.StudentRentals.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentrentals.StudentRentals.Entity.AdminEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

    AdminEntity findByAdminUser(String adminUser);
}


