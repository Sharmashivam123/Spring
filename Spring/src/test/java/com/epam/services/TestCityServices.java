package com.epam.services;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.bean.City;
import com.epam.dao.CityDao;
import com.epam.services.servicesImpl.CityServicesImpl;

class TestCityServices {

	@InjectMocks
	CityServicesImpl mock;

	@Mock
	private CityDao cityDao;

	@Test
	public void testCity() {
		MockitoAnnotations.initMocks(this);
		List<City> expectedCity = new ArrayList<>();
		City hyderabadCity = new City();
		hyderabadCity.setCityId(1);
		hyderabadCity.setCityName("Hyderabad");
		expectedCity.add(hyderabadCity);
		when((List<City>) cityDao.findAll()).thenReturn(expectedCity);
		assertEquals(expectedCity, (List<City>) cityDao.findAll());
	}
}
