package com.epam.service;

import com.epam.entity.User;
import com.epam.dto.ForgetPasswordDto;

public interface UserService {
	public User findByUserName(ForgetPasswordDto dto);

	public User saveUser(User user);
}
