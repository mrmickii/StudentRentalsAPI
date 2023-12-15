package com.studentrentals.StudentRentals.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.studentrentals.StudentRentals.Entity.StudentEntity;
import com.studentrentals.StudentRentals.Service.StudentService;

@RestController
@RequestMapping("/studentrentals")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<StudentEntity> login(@RequestParam String username, @RequestParam String password) {
        StudentEntity student = studentService.authenticate(username, password);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/insertStudent")
    public ResponseEntity<StudentEntity> insertStudent(@RequestBody StudentEntity student) {
        StudentEntity insertedStudent = studentService.insertStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedStudent);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<StudentEntity> updateStudent(
            @PathVariable int studentId,
            @RequestBody StudentEntity newStudentDetails) {
        StudentEntity updatedStudent = studentService.updateStudent(studentId, newStudentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        String message = studentService.deleteStudent(studentId);
        return ResponseEntity.ok(message);
    }
}
