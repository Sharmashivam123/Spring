package com.epam.bms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.sql.Time;

import org.apache.log4j.Logger;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.Theatre;
import com.epam.bms.util.DbUtilImpl;


public class DbOperationImpl implements DbOperation {

	private static final Logger log = Logger.getLogger(DbOperationImpl.class);

	Connection connection = null;

	@Override
	public List<City> getCityList() throws Exception {
		List<City> listCity = new ArrayList<>();
		try {
			String query = "Select cityId, cityName from city";
			DbUtilImpl resultSet = new DbUtilImpl();
			ResultSet result = resultSet.getResulSet(query);
			while (result.next()) {
				int cityId = result.getInt("cityId");
				String cityName = result.getString("cityName");
				City city = new City();
				city.setCityId(cityId);
				city.setCityName(cityName);
				listCity.add(city);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return listCity;
	}

	@Override
	public List<Area> getAreaListByCity(String cityId) {
		List<Area> list = new ArrayList<>();
		int id = Integer.parseInt(cityId);
		try {
			String query = "select pincode, areaName from location where cityId = '" + id + "'";
			DbUtilImpl resultSet = new DbUtilImpl();
			ResultSet result = resultSet.getResulSet(query);
			while (result.next()) {
				int pin = result.getInt("pincode");
				String areaName = result.getString("areaName");
				Area area = new Area();
				area.setAreaName(areaName);
				area.setPin(pin);
				list.add(area);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Movie> getMovieListByAreaPin(String pin) {
		List<Movie> listMovie = new ArrayList<>();
		int pincode = Integer.parseInt(pin);
		try {
			String query = "SELECT * from movie WHERE movieId IN (SELECT movieId from moviebylocation WHERE pincode ='"
					+ pincode + "')";
			DbUtilImpl resultSet = new DbUtilImpl();
			ResultSet result = resultSet.getResulSet(query);
			while (result.next()) {
				int movieId = result.getInt("movieId");
				String movieName = result.getString("movieName");
				Movie movie = new Movie();
				movie.setMovieId(movieId);
				movie.setMovieName(movieName);
				listMovie.add(movie);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return listMovie;
	}

	@Override
	public List<Theatre> getTheatreListByMovie(String movie) {
		List<Theatre> theatreList = new ArrayList<>();

		int movieId = Integer.parseInt(movie);
		try {
			String query = "select * from theatrewithshow where theatreId in (SELECT theatreId from theatrebymovie WHERE movieId = '"
					+ movieId + "')";
			DbUtilImpl resultSet = new DbUtilImpl();
			ResultSet result = resultSet.getResulSet(query);
			while (result.next()) {
				int theatreId = result.getInt("theatreId");
				String theatreName = result.getString("theatreName");
				Time time1 = result.getTime("show1");
				Time time2 = result.getTime("show2");
				Time time3 = result.getTime("show3");
				Time time4 = result.getTime("show4");
				List<Time> showtimings = Arrays.asList(time1, time2, time3, time4);
				Theatre theatre = new Theatre();
				theatre.setTheatreId(theatreId);
				theatre.setName(theatreName);
				theatre.setShowtimings(showtimings);
				theatreList.add(theatre);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return theatreList;
	}

	

}
