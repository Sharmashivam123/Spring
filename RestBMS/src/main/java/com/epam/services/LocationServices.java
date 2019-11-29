package com.epam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.bean.Location;
import com.epam.dao.LocationDao;

@Service
public class LocationServices {
	@Autowired
	private LocationDao areaDao;
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private Location location;

	public List<Location> getAreaPinInCity() {
		int cityId = bookingDetails.getCityId();
		location.setAreaName("error in city code");
		location.setPin(00000);
		location.setCityId(cityId);
		List<Location> listLocation = areaDao.findAllByCityId(cityId);
		return listLocation;
	}
}
