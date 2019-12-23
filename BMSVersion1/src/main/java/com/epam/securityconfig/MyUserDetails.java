package com.epam.securityconfig;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.epam.bean.Credentials;

@Service
public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails {

	private static final long serialVersionUID = 1L;

	private Credentials credential;

	public MyUserDetails(Credentials creedential) {
		this.credential = creedential;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> list = new HashSet<>();
		list.add(new SimpleGrantedAuthority("USER"));
		list.add(new SimpleGrantedAuthority("ADMIN"));
		return list;  
	}

	@Override
	public String getPassword() {
		return credential.getPwd();
	}

	@Override
	public String getUsername() {
		return credential.getUser();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}