package com.epam.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.bean.Credentials;
import com.epam.repo.UserDao;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserDao userRepo;

	@Override
	public UserDetails loadUserByUsername(String username)  {
		
		Optional<Credentials> userw = userRepo.findById(username);
		return new MyUserDetails(userw.orElseThrow(() -> new UsernameNotFoundException("User not found!!!")));

	}

}
