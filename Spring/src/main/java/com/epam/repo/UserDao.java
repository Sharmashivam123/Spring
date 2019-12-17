package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.bean.Credentials;

public interface UserDao extends JpaRepository<Credentials, String> {
	public Credentials findByUser(String user);
}
