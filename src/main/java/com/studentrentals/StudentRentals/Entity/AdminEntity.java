package com.studentrentals.StudentRentals.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbladmin")
public class AdminEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adminid")
	private int adminid;
	@Column(name="adminuser")
	private String adminUser;
	@Column(name="adminpassword")
	private String adminPass;
	
	public AdminEntity() {
		super();
	}

	public AdminEntity(String adminUser, String adminPass) {
		super();
		this.adminUser = adminUser;
		this.adminPass = adminPass;
	}

	public int getAdminid() {
		return adminid;
	}

	public String getUsername() {
        return adminUser;
    }

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public void setUsername(String username) {
        this.adminUser = username;
    }

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
}
