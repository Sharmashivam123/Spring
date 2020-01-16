package com.epam.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.City;
import com.epam.bean.Location;
import com.epam.repo.CityDao;
import com.epam.repo.LocationDao;
import com.epam.services.CityServices;

@Service
public class CityServicesImpl implements CityServices {
	@Autowired
	private CityDao cityDao;

	@Autowired
	private LocationDao locationDao;

	public List<City> getAvailableCities() {
		return (List<City>) cityDao.findAll();
	}

	public void delete(int cityId) {
		cityDao.deleteById(cityId);
	}

	@Override
	public City addCity(City city, int locations[]) {
		List<Location> locationList = new ArrayList<Location>();
		int n = locations.length;
		for (int i = 0; i < n; i++) {
			Optional<Location> location = locationDao.findById(locations[i]);
			if (location.isPresent())
				locationList.add(location.get());
		}
		city.setLocationList(locationList);
		return cityDao.save(city);
	}

	@Override
	public void update(int cityId, String cityName, int[] locations) {

		List<Location> locationList = new ArrayList<Location>();
		int n = locations.length;
		for (int i = 0; i < n; i++) {
			Optional<Location> location = locationDao.findById(locations[i]);
			if (location.isPresent())
				locationList.add(location.get());
		}

		Optional<City> optional = cityDao.findById(cityId);
		if (optional.isPresent()) {
			City city = optional.get();
			city.setCityName(cityName);
			city.setLocationList(locationList);
			cityDao.save(city);
		}

	}

}
