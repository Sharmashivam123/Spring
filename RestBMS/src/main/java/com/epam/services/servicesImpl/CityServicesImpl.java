package com.epam.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.City;
import com.epam.dao.CityDao;
import com.epam.services.CityServices;

@Service
public class CityServicesImpl implements CityServices{
	@Autowired
	private CityDao cityDao;
	
	public List<City> getAvailableCities() throws RuntimeException {
		List<City> cityList = (List<City>) cityDao.findAll();
		return cityList;
	}

}
