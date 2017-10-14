package com.zhiyou.clouddisk.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AppUser {
	private Long userId;
	private String userName;
	private String gender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String accountNo;
	private String password;
	private String email;
	private String phoneNo;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", birthday=" + birthday
				+ ", accountNo=" + accountNo + ", password=" + password + ", email=" + email + ", phoneNo=" + phoneNo
				+ "]";
	}
}
