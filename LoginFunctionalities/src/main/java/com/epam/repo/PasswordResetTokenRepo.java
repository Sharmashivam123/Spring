package com.epam.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.entity.PasswordResetToken;

@Repository
public interface PasswordResetTokenRepo extends CrudRepository<PasswordResetToken, Long> {

	PasswordResetToken findByToken(String token);

}
