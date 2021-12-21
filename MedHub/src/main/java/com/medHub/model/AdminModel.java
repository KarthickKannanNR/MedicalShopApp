package com.medHub.model;

import java.util.Objects;

public class AdminModel {
	
	private int adminId;
	private String adminName;
	private int age;
	private long adminmobile;
	private String adminMail;
	private String adminPassword;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getAdminmobile() {
		return adminmobile;
	}
	public void setAdminmobile(long adminmobile) {
		this.adminmobile = adminmobile;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminId, adminMail, adminName, adminPassword, adminmobile, age);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminModel other = (AdminModel) obj;
		return adminId == other.adminId && Objects.equals(adminMail, other.adminMail)
				&& Objects.equals(adminName, other.adminName) && Objects.equals(adminPassword, other.adminPassword)
				&& adminmobile == other.adminmobile && Objects.equals(age, other.age)
				;
	}
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminModel(int adminId, String adminName, String gender, int age, long adminmobile, String adminMail,
			String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		
		this.age = age;
		this.adminmobile = adminmobile;
		this.adminMail = adminMail;
		this.adminPassword = adminPassword;
	}
	public AdminModel(String string, int int1, String string2, String string3, long long1) {
		
		this.adminName = string;
		this.age = int1;
		this.adminmobile = long1;
		this.adminMail = string3;
		this.adminPassword = string2;
	}
	@Override
	public String toString() {
		return "adminId=" + adminId + ", adminName=" + adminName + ", age=" + age
				+ ", adminmobile=" + adminmobile + ", adminMail=" + adminMail + ", adminPassword=" + adminPassword;
	}
	
	

}
