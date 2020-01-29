package com.epam.dto;

import javax.validation.constraints.NotEmpty;
import com.epam.constraint.*;

@FieldMatch.List({
		@FieldMatch(first = "password", second = "confirmPassword", message = "Password Does'nt Matches the Confirm Password.") })
public class ResetPasswordDto {

	@NotEmpty(message = "password cann't be null")
	private String password;
	@NotEmpty(message = "confirm Passwword cant be null")
	private String confirmPassword;
	@NotEmpty(message = "token cant be null")
	private String token;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
