package com.studentrentals.StudentRentals.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblstudent")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    @Column(name = "firstname")
    private String first_name;

    @Column(name = "lastname")
    private String last_name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phonenumber")
    private String phone_number;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username; // Added username field

    public StudentEntity() {
        super();
    }

    public StudentEntity(int student_id, String first_name, String last_name, String gender,
                         String phone_number, String password, String username) {
        super();
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.phone_number = phone_number;
        this.password = password;
        this.username = username;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
