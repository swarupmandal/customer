package com.ms.cust.dto;

public class LoginDto {

	long phoneNo;
	String password;
	
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LoginDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "LoginDto [phoneNo=" + phoneNo + ", password=" + password + "]";
	}	
	
}
