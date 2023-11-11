package com.studentrentals.StudentRentals.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentrentals.StudentRentals.Entity.PropertyEntity;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Integer>{

}
