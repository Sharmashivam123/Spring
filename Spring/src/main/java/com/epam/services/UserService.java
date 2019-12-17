package com.epam.services;

import com.epam.bean.Credentials;

public interface UserService {
	public Credentials getUserData(String user);

	public Credentials update(Credentials credentials);

	public Credentials registerUser(Credentials credential);
}
