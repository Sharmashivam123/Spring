package com.epam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.City;
import com.epam.dao.CityDao;

@Service
public class CityServices {
	@Autowired
	private CityDao cityDao;
	
	public List<City> getAvailableCities() throws RuntimeException {
		List<City> cityList = (List<City>) cityDao.findAll();
		return cityList;
	}

}
