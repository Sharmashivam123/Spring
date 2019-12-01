package com.epam.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.bean.Location;
import com.epam.dao.LocationDao;
import com.epam.services.LocationServices;

@Service
public class LocationServicesImpl implements LocationServices {
	@Autowired
	private LocationDao areaDao;
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private Location location;

	public List<Location> getAreaPinInCity() throws RuntimeException {
		int cityId = bookingDetails.getCityId();
		location.setAreaName("error in city code");
		location.setPin(00000);
		location.setCityId(cityId);
		List<Location> listLocation = areaDao.findAllByCityId(cityId);
		return listLocation;
	}
}
