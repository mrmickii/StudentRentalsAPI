package com.studentrentals.StudentRentals.DTO;

public class AdminDTO {

    private String adminUser;
    private String adminPass;
    
	public AdminDTO() {
		super();
	}
	public AdminDTO(String adminUser, String adminPass) {
		super();
		this.adminUser = adminUser;
		this.adminPass = adminPass;
	}
	public String getAdminUser() {
        return adminUser;
    }

    public String getAdminPass() {
        return adminPass;
    }
	public void setUsername(String adminUser) {
		this.adminUser = adminUser;
	}
	public void setPassword(String adminPass) {
		this.adminPass = adminPass;
	}
}

