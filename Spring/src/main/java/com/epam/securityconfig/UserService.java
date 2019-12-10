package com.epam.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.bean.Credentials;
import com.epam.dao.UserDao;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserDao userRepo;

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		Optional<Credentials> userw = userRepo.findById(user);
		return new MyUserDetails(userw.orElseThrow(() -> new UsernameNotFoundException("User not found!!!")));

	}

}
