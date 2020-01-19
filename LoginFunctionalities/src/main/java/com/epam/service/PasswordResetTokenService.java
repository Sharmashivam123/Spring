package com.epam.service;

import com.epam.Entity.PasswordResetToken;

public interface PasswordResetTokenService {
	PasswordResetToken saveToken(PasswordResetToken token);
}
