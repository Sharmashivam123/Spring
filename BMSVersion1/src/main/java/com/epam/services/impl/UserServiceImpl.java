package com.epam.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.Credentials;
import com.epam.repo.UserDao;
import com.epam.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao user;

	@Override
	public Credentials getUserData(String username) {
		return user.findByUser(username);
	}

	@Override
	public Credentials registerUser(Credentials credentials) {
		String email = credentials.getUser();
		Optional<Credentials> credential = user.findById(email);
		if (!credential.isPresent())
			credentials = user.save(credentials);
		else
			return null;
		return credentials;
	}

	@Override
	public Credentials update(Credentials credentials) {
		credentials = user.save(credentials);
		return credentials;
	}

}
