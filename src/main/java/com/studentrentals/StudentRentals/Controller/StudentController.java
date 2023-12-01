package com.studentrentals.StudentRentals.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentrentals.StudentRentals.Entity.StudentEntity;
import com.studentrentals.StudentRentals.Service.StudentService;

@RestController
@RequestMapping("/studentrentals")
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService sserv;

	
	//C- Create a student record 
	@PostMapping("/insertStudent")
	public StudentEntity insertStudent(@RequestBody StudentEntity student) {
		return sserv.insertStudent(student);
	}
	
	//R- read all student records in tblstudent
	@GetMapping("/getAllStudents")
	public List<StudentEntity>getAllStudents(){
		return sserv.getAllStudents();
	}
	
	//U- update a student record
	@PutMapping("/updateStudent")
	public StudentEntity updateStudent(@RequestParam int student_id, @RequestBody StudentEntity newStudentDetails) {
		return sserv.updateStudent(student_id, newStudentDetails);
	}
	
	//D- delete a student record
	@DeleteMapping("/deleteStudent/{student_id}")
	public String deleteStudent(@PathVariable int student_id) {
		return sserv.deleteStudent(student_id);
	}
	
}

