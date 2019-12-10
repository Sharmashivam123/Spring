package com.epam.securityconfig;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.epam.bean.Credentials;

@Service
public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails {

	private static final long serialVersionUID = 1L;
	Credentials credential;

	public MyUserDetails(Credentials creedential) {
		this.credential = creedential;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		System.out.println(credential.getPwd());
		return credential.getPwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return credential.getUser();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
