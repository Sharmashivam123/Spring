package com.epam.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="location")
public class Location {
	@Id
	private int pincode;
	private int cityId;
	private String areaName;

	public int getPin() {
		return pincode;
	}

	public void setPin(int pincode) {
		this.pincode = pincode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	

}
