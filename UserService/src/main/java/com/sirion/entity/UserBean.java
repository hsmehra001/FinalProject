package com.sirion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table")
public class UserBean {
	@Id
	private String uid;
	private String password;
	private String role;
	public String getUserId() {
		return uid;
	}
	public void setUserId(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserBean() {
		
	}
	public UserBean(String uid, String password, String role) {
		super();
		this.uid = uid;
		this.password = password;
		this.role = role;
	}
}
