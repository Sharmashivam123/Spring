package com.epam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.bean.Credentials;

public interface UserDao extends JpaRepository<Credentials, String> {

}
