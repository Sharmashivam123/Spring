package com.epam.repo;

import org.springframework.data.repository.CrudRepository;

import com.epam.entity.PasswordResetToken;

public interface PasswordResetTokenRepo extends CrudRepository<PasswordResetToken, Long> {

}
