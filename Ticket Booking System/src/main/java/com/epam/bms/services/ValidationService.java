package com.epam.bms.services;

import java.util.List;
import java.util.Map;

import com.epam.bms.models.City;
import com.epam.bms.models.Location;
import com.epam.bms.models.Movie;
import com.epam.bms.dao.TraverseData;
import com.epam.bms.dao.TraverseDataImpl;

public class ValidationService {

	private TraverseData data = new TraverseDataImpl();

	public boolean validatePin(String pin, String city) {
		boolean check = true;
		String pattern = "^[0-9]+$";
		if (!pin.matches(pattern)) {
			check = false;
		} else {
			int pincode = Integer.parseInt(pin);
			int cityId = Integer.parseInt(city);
			check = containsPin(pincode,cityId);
		}
		return check;
	}

	public boolean validateMovieName(String movieName, String pin) {
		List<Movie> list = data.getMovieListByPin(Integer.parseInt(pin));
		for (Movie m : list) {
			if (m.getMovieName().equals(movieName))
				return true;
		}
		return false;

	}

	public boolean validateId(int id) {
		if (id <= 4 && id > 0) {
			return true;
		} else
			return false;
	}

	public boolean validatePrice(int price) {
		boolean check = false;
		Map<String, Integer> range = data.getRangeOfSeat();
		for (Map.Entry<String, Integer> map : range.entrySet()) {
			if (map.getValue() == price)
				check = true;
		}
		return check;
	}

	public boolean containsPin(int pin, int cityId) {
		boolean check = false;
		List<Location> list = data.getLocationByCity(cityId);
		for (Location loc : list) {
			if (loc.getPin() == pin) {
				check = true;
				break;
			}
			check = false;
		}
		return check;
	}

	public boolean validateCity(String city) {
		boolean check = true;
		String pattern = "^[0-9]+$";
		if (!city.matches(pattern)) {
			check = false;
		} else {
			int cityId = Integer.parseInt(city);
			check = containsCity(cityId);
		}
		return check;
	}

	private boolean containsCity(int cityId) {
		boolean check = false;
		List<City> list = data.getCity();
		for (City loc : list) {
			if (loc.getCityId() == cityId) {
				check = true;
				break;
			}
			check = false;
		}
		return check;
	}
}
