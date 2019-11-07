package com.epam.bms.dao;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.SeatRange;
import com.epam.bms.bean.Theatre;
import com.epam.bms.util.BookingDetails;
import com.epam.bms.util.DbUtilImpl;
import com.epam.bms.util.ShowTimes;

public class DBOperationImpl implements DBOperation {

	private static final Logger log = Logger.getLogger(DBOperationImpl.class);
	private DbUtilImpl resultSet = new DbUtilImpl();
	private BookingDetails bookingDetails = BookingDetails.getInstance();

	
	
	@Override
	public List<City> getCityList() throws Exception {
		List<City> listCity = new ArrayList<>();
		try {
			String query = "Select cityId, cityName from city";
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
	public List<Area> getAreaListByCity(int cityId) {
		List<Area> list = new ArrayList<>();
		try {
			String query = "select pincode, areaName from location where cityId = '" + cityId + "'";
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
			log.error(e.getMessage());
		}
		return list;
	}

	
	
	@Override
	public List<Movie> getMovieListByAreaPin(int pin) {
		List<Movie> listMovie = new ArrayList<>();
		try {
			String query = "SELECT * from movie WHERE movieId IN (SELECT movieId from moviebylocation WHERE pincode ='"
					+ pin + "')";
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
	public List<Theatre> getTheatreListByMovie(int movieId) {
		List<Theatre> theatreList = new ArrayList<>();
		try {
			String query = "select * from theatre where theatreId in (SELECT theatreId from theatrebymovie WHERE movieId = '"
					+ movieId + "')";
			ResultSet result = resultSet.getResulSet(query);
			while (result.next()) {
				int theatreId = result.getInt("theatreId");
				String theatreName = result.getString("theatreName");
				Theatre theatre = new Theatre();
				theatre.setTheatreId(theatreId);
				theatre.setName(theatreName);
				theatreList.add(theatre);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return theatreList;
	}

	
	
	@Override
	public List<SeatRange> getPriceRange(String tier) {
	String query = "select * from seatarrangements where tier = '"+tier+"'";
	List<SeatRange> seatRangeList = new ArrayList<>();
		try {
			ResultSet result = resultSet.getResulSet(query);
			while (result.next()) {
				double cost = result.getDouble("cost");
				String seatId = result.getString("seatId");
				SeatRange seat = new SeatRange();
				seat.setSeatId(seatId);
				seat.setCost(cost);
				seat.setTier(tier);
				seatRangeList.add(seat);
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return seatRangeList;
	}

	
	
	@Override
	public Map<Integer, LocalTime> getShowtimings(int dateId) {
		int index = 0;
		int movieId = bookingDetails.getMovieId();
		int theatreId = bookingDetails.getTheatreId();
		BookingDates bookingDates = new BookingDates();
		Map<Integer, LocalDate> dateMap = bookingDates.getDates();
		LocalDate currentDate = LocalDate.now();
		LocalDate selectedDate = dateMap.get(dateId);
		List<LocalTime> timeList = new ArrayList<>();

		Map<Integer, LocalTime> timeIndexMap = new HashMap<>();
		try {
			String query = "select show1, show2, show3, show4 from showtiming \r\n"
					+ "where timingId = (select timingId from theatrebymovie \r\n" + "where theatreId = '" + theatreId
					+ "' and movieId = '" + movieId + "')";
			ResultSet result = resultSet.getResulSet(query);
			while (result.next()) {
				LocalTime show1 = LocalTime.parse(result.getTime("show1").toString());
				LocalTime show2 = LocalTime.parse(result.getTime("show2").toString());
				LocalTime show3 = LocalTime.parse(result.getTime("show3").toString());
				LocalTime show4 = LocalTime.parse(result.getTime("show4").toString());
				timeList.addAll(Arrays.asList(show1, show2, show3, show4));
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		for (LocalTime time : timeList) {
			if (currentDate.compareTo(selectedDate) == 0)
				if (time.compareTo(LocalTime.now().plusMinutes(15)) > 0)
					timeIndexMap.put(++index, time);
				else
					;
			else
				timeIndexMap.put(++index, time);
		}
		ShowTimes showTimes =ShowTimes.getInstatnce();
		showTimes.setAvailableShow(timeIndexMap);
		return timeIndexMap;
	}

	
	
	@Override
	public double getCost(int rangeId) {
		double cost = 0;
		String query = "select cost from pricerange where rangeId= '" + rangeId + "' ";
		try {
			ResultSet result = resultSet.getResulSet(query);
			while (result.next()) {
				cost = result.getDouble("cost");
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return cost;
	}



	@Override
	public boolean processBooking() {
		boolean check = false;
		return check;
	}



	

}
