package com.epam.bms.services;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.ShowTimes;
import com.epam.bms.bean.Theatre;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.dao.DBOperationImpl;

public class ValidationService {

	private DBOperation dBOperation = new DBOperationImpl();

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
		List<City> list = dBOperation.getCityList();
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
		List<Area> listArea = dBOperation.getAreaListByCity(Integer.parseInt(cityId));
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
		List<Movie> list = dBOperation.getMovieListByAreaPin(Integer.parseInt(pin));
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

	public boolean validateTheatreId(String theatreId, int movieId) {
		boolean check = false;
		if (theatreId.matches("^[0-9]+$"))
			check = containsTheatreId(theatreId, movieId);
		return check;
	}

	private boolean containsTheatreId(String theatreId, int movieId) {
		boolean check = false;
		List<Theatre> listTheatre = dBOperation.getTheatreListByMovie(movieId);
		for (Theatre theatre : listTheatre) {
			int id = theatre.getTheatreId();
			if (id == Integer.parseInt(theatreId)) {
				check = true;
				break;
			}

		}
		return check;
	}

	// public boolean validateShowTime(int theatreId, String timeId) {
	// boolean check = false;
	// if (timeId.matches("^[0-9]+$")) {
	// check = containsTime(theatreId, timeId);
	// }
	// return check;
	// }
	//
	// private boolean containsTime(int theatreId, String timeId) {
	// boolean check = false;
	// int showTimeId = Integer.parseInt(timeId);
	// if (showTimeId < (showsCount - 1))
	// check = true;
	// return check;
	// }

	public boolean validateShow(String show) {
		boolean check = false;
		ShowTimes showTime = ShowTimes.getInstatnce();
		int showId = Integer.parseInt(show);
		Map<Integer, LocalTime> availableShow = showTime.getAvailableShow();
		if (availableShow.containsKey(showId))
			check = true;
		return check;
	}

	public boolean validateRange(String range) {
		boolean check = false;
		if (range.matches("[1-3]"))
			check = true;
		return check;
	}

	public boolean validateSeatCount(String numberOfTickets) {
		boolean check = false;
		if (numberOfTickets.matches("^[0-9]$"))
			check = true;
		return check;
	}

}
