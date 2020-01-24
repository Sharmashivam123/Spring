package com.epam.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.User;
import com.epam.dto.ForgetPasswordDto;
import com.epam.repo.UserRepo;
import com.epam.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo repo;

	@Override
	public User findByUserName(ForgetPasswordDto dto) {
		return repo.findByUsername(dto.getEmail());
	}

	@Override
	public User saveUser(User user) {
		return repo.save(user);
	}

}
