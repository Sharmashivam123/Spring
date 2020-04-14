package com.epam.dto;

import javax.validation.constraints.NotEmpty;

import com.epam.constraint.FieldMatch;

@FieldMatch(first = "password", second = "confirmPassword", message = "confirmPassword doesn't match ")
public class UserRegisterationDto {

	@NotEmpty(message = "UserName can't be null")
	private String username;
	@NotEmpty(message = "Password can't be null")
	private String password;
	@NotEmpty(message = "Password must match the confirm password")
	private String confirmPassword;

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@NotEmpty
	private String phone;
	@NotEmpty
	private String role;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
