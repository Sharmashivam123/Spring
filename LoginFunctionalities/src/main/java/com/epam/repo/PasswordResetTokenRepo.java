package com.epam.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.Entity.PasswordResetToken;

@Repository
public interface PasswordResetTokenRepo extends CrudRepository<PasswordResetToken, Long> {

}
