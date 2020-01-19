package com.epam.service;

import com.epam.Entity.User;
import com.epam.dto.ForgetPasswordDto;

public interface UserService {
	public User findByUserName(ForgetPasswordDto dto);
}
