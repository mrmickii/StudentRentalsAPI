package com.studentrentals.StudentRentals.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentrentals.StudentRentals.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}