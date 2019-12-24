package com.epam.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.City;
import com.epam.repo.CityDao;
import com.epam.services.CityServices;

@Service
public class CityServicesImpl implements CityServices {
	@Autowired
	private CityDao cityDao;

	public List<City> getAvailableCities() {
		return (List<City>) cityDao.findAll();
	}

	public City update(City city) {
		Optional<City> optional = cityDao.findById(city.getCityId());
		if (optional.isPresent()) {
			city = cityDao.save(city);
		}
		return city;
	}
	public void delete(int cityId)
	{
		cityDao.deleteById(cityId);
	}

	@Override
	public City addCity(City city) {
		return cityDao.save(city);
	}

}
