package com.epam.services.impl;

import java.util.List;

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

}
