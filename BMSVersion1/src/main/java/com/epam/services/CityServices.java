package com.epam.services;

import java.util.List;

import com.epam.bean.City;

public interface CityServices {
	public List<City> getAvailableCities();

	public void delete(int cityId);

	public void update(int cityId, String cityName, int[] locations);

	public City addCity(City city, int locations[]);
}
