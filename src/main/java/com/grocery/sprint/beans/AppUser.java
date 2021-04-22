package com.grocery.sprint.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app_user")
public class AppUser {
	
	@Id
	private long userId;
	private String password;
	private String userType;
	
	public AppUser() {}

	public AppUser(String password, String userType) {
		super();
		this.password = password;
		this.userType = userType;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", password=" + password + ", userType=" + userType + "]";
	}
	
}
