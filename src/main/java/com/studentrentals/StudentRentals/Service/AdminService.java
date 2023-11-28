package com.studentrentals.StudentRentals.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentrentals.StudentRentals.Entity.AdminEntity;
import com.studentrentals.StudentRentals.Repository.AdminRepository;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void initializeAdmin() {
        String adminUser = "admin";
        String adminPass = "adminpassword";

        // Check if the admin user already exists
        if (adminRepository.findByAdminUser(adminUser) == null) {
        	AdminEntity admin = new AdminEntity();
            admin.setUsername(adminUser);
            admin.setAdminPass(adminPass);  // You should use a password encoder for production

            adminRepository.save(admin);
        }
    }

    public boolean authenticateAdmin(String adminUser, String adminPass) {
    	AdminEntity admin = adminRepository.findByAdminUser(adminUser);
        return admin != null && admin.getAdminPass().equals(adminPass);
    }
}
