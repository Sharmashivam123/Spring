package com.epam.service;

import com.epam.dto.ForgetPasswordDto;
import com.epam.entity.User;

public interface UserService {
	public User findByUserName(ForgetPasswordDto dto);

	public User saveUser(User user);

	public void updatePassword(User user, String password);
}
