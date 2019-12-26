package com.epam.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "location")
public class Location {
	@Id
	private int locationId;
	private int cityId;
	private String locationName;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int pincode) {
		this.locationId = pincode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String areaName) {
		this.locationName = areaName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}
