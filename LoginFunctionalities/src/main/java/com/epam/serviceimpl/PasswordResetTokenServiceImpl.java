package com.epam.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.Entity.PasswordResetToken;
import com.epam.repo.PasswordResetTokenRepo;
import com.epam.service.PasswordResetTokenService;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

	@Autowired
	PasswordResetTokenRepo repo;

	@Override
	public PasswordResetToken saveToken(PasswordResetToken token) {
		return repo.save(token);
	}

}
