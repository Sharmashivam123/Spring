package com.epam.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.Location;
import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.repo.LocationDao;
import com.epam.services.LocationServices;
import com.epam.util.ApplicationConstants;

@Service
public class LocationServicesImpl implements LocationServices {
	@Autowired
	private LocationDao areaDao;

	public List<Location> getAreaPinInCity(int cityId) {

		return Optional.ofNullable(areaDao.findAllByCityId(cityId)).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));

	}

	@Override
	public List<Location> getAll() {
		return (List<Location>) areaDao.findAll();
	}

	@Override
	public Location update(Location location) {
		Optional<Location> optional = areaDao.findById(location.getLocationId());
		if (optional.isPresent()) {
			location = areaDao.save(location);
		}
		return location;

	}

	@Override
	public void delete(int locationId) {
		areaDao.deleteById(locationId);
	}

	@Override
	public Location addLocation(Location location) {
		return areaDao.save(location);
	}
}
