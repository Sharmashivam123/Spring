package com.epam.dto;

import javax.validation.constraints.NotEmpty;

public class ForgetPasswordDto {

	@NotEmpty
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
