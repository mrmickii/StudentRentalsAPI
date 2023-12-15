package com.studentrentals.StudentRentals.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.studentrentals.StudentRentals.Entity.StudentEntity;
import com.studentrentals.StudentRentals.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity authenticate(String username, String password) {
        return studentRepository.findByUsernameAndPassword(username, password);
    }

    public StudentEntity insertStudent(StudentEntity student) {
        String username = student.getFirst_name().toLowerCase() + "." + student.getLast_name().toLowerCase();
        student.setUsername(username);
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity updateStudent(int studentId, StudentEntity newStudentDetails) {
        StudentEntity existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Update the existing student with new details
        existingStudent.setFirst_name(newStudentDetails.getFirst_name());
        existingStudent.setLast_name(newStudentDetails.getLast_name());
        existingStudent.setGender(newStudentDetails.getGender());
        existingStudent.setPhone_number(newStudentDetails.getPhone_number());
        existingStudent.setPassword(newStudentDetails.getPassword());

        return studentRepository.save(existingStudent);
    }

    public String deleteStudent(int studentId) {
        if (studentRepository.existsById(studentId)) {
            studentRepository.deleteById(studentId);
            return "Student deleted successfully";
        } else {
            return "Student not found";
        }
    }
}
