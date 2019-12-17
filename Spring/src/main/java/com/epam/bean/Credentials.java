package com.epam.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "credentials")
@Component
public class Credentials {
	@Override
	public String toString() {
		return "Credentials [user=" + user + ", pwd=" + pwd + ", phone=" + phone + "]";
	}

	@Id
	private String user;
	private String pwd;
	private String phone;
	private String otp;
	private int status;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMyhash() {
		return otp;
	}

	public void setMyhash(String myhash) {
		this.otp = myhash;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
