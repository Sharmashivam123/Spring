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
	DbOperation dbOperation = new DbOperationImpl();

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

	public boolean validateShowTimings(String input, String movieId) {
		boolean check = false;
		String[] theatreAndShow = input.split(" ");
		String theatreId = "", showTime = "";
		if (theatreAndShow.length == 2)
			 {
			theatreId = theatreAndShow[0];
			showTime = theatreAndShow[1];
			if (validateTheatre(theatreId, movieId, showTime))
					check = true;
		}
		return check;
	}


	
	private boolean validateTheatre(String theatreId, String movieId, String showTime) {
		boolean check = false;
		if(theatreId.matches("^[0-9]+$"))
			check = containsTheatreId(theatreId,movieId,showTime);
		return check;
	}

	private boolean containsTheatreId(String theatreId, String movieId, String showTime) {
		boolean check = false;
		List<Theatre> listTheatre = dbOperation.getTheatreListByMovie(movieId);
		for(Theatre theatre: listTheatre)
		{
			List<Time> shows = theatre.getShowtimings();
			int id = theatre.getTheatreId();
			if(id == Integer.parseInt(theatreId)) {
				Time time = Time.valueOf(showTime);
				for(Time t : shows)
				{
					if(t.equals(time))
					{
						check = true;break;
					}
				}
				if(check)break;
			}
		}
		return check;
	}

}
