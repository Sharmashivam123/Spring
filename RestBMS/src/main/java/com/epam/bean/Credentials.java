package com.epam.bean;

import org.springframework.stereotype.Component;

@Component
public class Credentials {
	private String username = "Shivam123";
	private String password = "Shivam@123";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
