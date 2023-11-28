package com.studentrentals.StudentRentals.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentrentals.StudentRentals.DTO.AdminDTO;
import com.studentrentals.StudentRentals.Entity.AdminEntity;
import com.studentrentals.StudentRentals.Service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentrentals")
@CrossOrigin
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin")
    public String adminLogin(@RequestBody AdminDTO loginRequest) {
        adminService.initializeAdmin();

        if (adminService.authenticateAdmin(loginRequest.getAdminUser(), loginRequest.getAdminPass())) {
            return "Admin login successful";
        } else {
            throw new RuntimeException("Admin login failed");
        }
    }

}
	
