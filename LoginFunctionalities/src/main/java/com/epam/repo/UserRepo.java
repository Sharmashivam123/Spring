package com.epam.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.Entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	User findByUsername(String email);

}
