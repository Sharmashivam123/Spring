package com.epam.dao;

import org.springframework.data.repository.CrudRepository;


import com.epam.bean.UserDetails;

public interface UserDetailsDao extends CrudRepository<UserDetails, Integer>{

}
