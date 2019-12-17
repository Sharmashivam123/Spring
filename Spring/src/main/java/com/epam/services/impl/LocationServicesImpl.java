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
}
