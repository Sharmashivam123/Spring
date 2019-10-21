package com.epam.bms.services;

import java.sql.Time;
import java.util.List;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.dao.DbOperation;
import com.epam.bms.dao.DbOperationImpl;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.Theatre;

public class ValidationService {
	private DbOperation dbOperation = new DbOperationImpl();
	private int showsCount = 0;

	public boolean validateCity(String city) throws Exception {
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

	private boolean containsCity(int cityId) throws Exception {
		boolean check = false;
		List<City> list = dbOperation.getCityList();
		for (City loc : list) {
			if (loc.getCityId() == cityId) {
				check = true;
				break;
			}
			check = false;
		}
		return check;
	}

	public boolean validatePin(String pin, String cityId) {
		boolean check = true;
		String pattern = "^[0-9]+$";
		if (!pin.matches(pattern)) {
			check = false;
		} else {
			int pincode = Integer.parseInt(pin);
			check = containsPin(pincode, cityId);
		}
		return check;
	}

	private boolean containsPin(int pin, String cityId) {
		boolean check = false;
		List<Area> listArea = dbOperation.getAreaListByCity(cityId);
		for (Area loc : listArea) {
			if (loc.getPin() == pin) {
				check = true;
				break;
			}
			check = false;
		}
		return check;
	}

	public boolean validateMovieName(String movieId, String pin) {
		boolean check = true;
		String pattern = "^[0-9]+$";
		if (!movieId.matches(pattern)) {
			check = false;
		} else {
			check = containsMovie(movieId, pin);
		}
		return check;
	}

	private boolean containsMovie(String movieId, String pin) {
		List<Movie> list = dbOperation.getMovieListByAreaPin(pin);
		boolean check = false;
		int id = Integer.parseInt(movieId);
		for (Movie movie : list) {
			if (movie.getMovieId() == id) {
				check = true;
				break;
			}
		}
		return check;
	}

	public boolean validateTheatreId(String theatreId, String movieId) {
		boolean check = false;
		if (theatreId.matches("^[0-9]+$"))
			check = containsTheatreId(theatreId, movieId);
		return check;
	}

	private boolean containsTheatreId(String theatreId, String movieId) {
		boolean check = false;
		List<Theatre> listTheatre = dbOperation.getTheatreListByMovie(movieId);
		for (Theatre theatre : listTheatre) {
			int id = theatre.getTheatreId();
			if (id == Integer.parseInt(theatreId)) {
				List<Time> shows = theatre.getShowtimings();
				showsCount = shows.size();
				check = true;
				break;
			}

		}
		return check;
	}

	public boolean validateShowTime(String theatreId, String timeId) {
		boolean check = false;
		if (timeId.matches("^[0-9]+$")) {
			check = containsTime(theatreId, timeId);
		}
		return check;
	}

	private boolean containsTime(String theatreId, String timeId) {
		boolean check =false;
		int showTimeId = Integer.parseInt(timeId);
		if(showTimeId < (showsCount-1))check = true;
		return check;
	}

}
