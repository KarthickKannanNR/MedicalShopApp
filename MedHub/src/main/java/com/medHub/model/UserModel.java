package com.medHub.model;

import java.util.Date;

public class UserModel {
	private int userId;
	private String Username;
	private String address;
	private String userMail;
	private long userMobile;
	private int age;
	private int points;
	private String userPassword;
	private double wallet;
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public long getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(long userMobile) {
		this.userMobile = userMobile;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return Username;
	}
	public void setName(String name) {
		this.Username = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public UserModel(int userId, String username, String address ,String userPassword,int wallet,String userMail,
			int age,int points,long userMobile) {
		super();
		this.userId = userId;
		Username = username;
		this.address = address;
		this.userMail = userMail;
		this.userMobile = userMobile;
		this.age = age;
		this.points = points;
		this.userPassword = userPassword;
		this.wallet = wallet;
	}
	public UserModel(String username,  int age,long userMobile, String userMail, String userPassword) {
		super();
		Username = username;
		this.userMail = userMail;
		this.userMobile = userMobile;
		this.age = age;
		this.userPassword = userPassword;
	}
	public UserModel( String string, String string2, String string3, String string4, String string5, int int2,
			int int3, long long1) {
		// TODO Auto-generated constructor stub
		
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "UserModule userId=" + userId + ", name=" + Username + ", address=" + address
				+ ", userMail=" + userMail + ", userPassword=" + userPassword + ", wallet=" + wallet ;
	}
	
	
	
	

}
