package com.studentrentals.StudentRentals.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.StudentEntity;
import com.studentrentals.StudentRentals.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository srepo;
	
	//C- Create or insert student record in tblstudent
	public StudentEntity insertStudent(StudentEntity student) {
		return srepo.save(student);
	}
	
	//R- Read all records in tblstudent
	public List<StudentEntity> getAllStudents(){
		return srepo.findAll();
	}
	
	//U- update a student
	@SuppressWarnings("finally")
	public StudentEntity updateStudent(int student_id, StudentEntity newStudentDetails) {
		StudentEntity student = new StudentEntity();
		try {
			//1. search the id number of the student that will be updated
			student = srepo.findById(student_id).get();
			
			//2. update the record
			student.setFirst_name(newStudentDetails.getFirst_name());
			student.setLast_name(newStudentDetails.getLast_name());
			student.setAddress(newStudentDetails.getAddress());
			student.setEmail(newStudentDetails.getEmail());
			student.setPhone_number(newStudentDetails.getPhone_number());
		}catch(NoSuchElementException ex) {
			throw new NoSuchElementException("Student "+student_id+" does not exist");
		}finally {
			return srepo.save(student);
		}
	}
	
	//D- delete a student
	public String deleteStudent(int student_id) {
		String msg = "tangina mo tapos na na delete na";
		
		if(srepo.findById(student_id) != null) {
			srepo.deleteById(student_id);
		}else
			msg = "Student " + student_id + " does not exist.";
		
		return msg;
	}
	
}

