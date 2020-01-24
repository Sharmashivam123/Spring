package com.epam.service;

import com.epam.entity.PasswordResetToken;

public interface PasswordResetTokenService {
	PasswordResetToken saveToken(PasswordResetToken token);
	PasswordResetToken findByToken(String token);
}
