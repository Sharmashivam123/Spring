package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	private Date birthDate;

	private String name;

	private boolean admin;

	private User[] user;

	private int rating;

	public User(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [birthDate=" + birthDate + ", name=" + name + ", admin=" + admin + ", subordinateArray="
				+ Arrays.toString(user) + ", iRating=" + rating + "]";
	}

}
