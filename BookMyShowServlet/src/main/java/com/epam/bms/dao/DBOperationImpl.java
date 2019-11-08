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
import com.epam.bms.bean.ShowTimes;
import com.epam.bms.bean.Theatre;
import com.epam.bms.util.BookingDetails;
import com.epam.bms.util.DbUtil;
import com.epam.bms.util.DbUtilImpl;
import com.epam.bms.util.TicketsDetails;

public class DBOperationImpl implements DBOperation {

	private static final Logger log = Logger.getLogger(DBOperationImpl.class);
	private DbUtil dbUtil = new DbUtilImpl();
	private BookingDetails bookingDetails = BookingDetails.getInstance();

	@Override
	public List<City> getCityList() {
		List<City> listCity = new ArrayList<>();
		try { 
			String query = "Select cityId, cityName from city";
			ResultSet result = dbUtil.getResulSet(query);
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
			ResultSet result = dbUtil.getResulSet(query);
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
			ResultSet result = dbUtil.getResulSet(query);
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
			ResultSet result = dbUtil.getResulSet(query);
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
		int movieId = bookingDetails.getMovieId();
		int theatreId = bookingDetails.getTheatreId();
		LocalTime time = bookingDetails.getTime();
		LocalDate date = bookingDetails.getDate();
		String query = "select seatId, tier, cost from seatarrangements where\r\n"
				+ " seatId Not In (select seatId from bookings where \r\n" + " showDate = '" + date
				+ "' and showtiming = '" + time + "' and theatreId = '" + theatreId + "'  and movieId = '" + movieId
				+ "' ) and tier ='" + tier + "';";
		List<SeatRange> seatRangeList = new ArrayList<>();
		try {
			ResultSet result = dbUtil.getResulSet(query);
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
			ResultSet result = dbUtil.getResulSet(query);
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
		ShowTimes showTimes = ShowTimes.getInstatnce();
		showTimes.setAvailableShow(timeIndexMap);
		return timeIndexMap;
	}

	@Override
	public double getCost(int rangeId) {
		double cost = 0;
		String query = "select cost from pricerange where rangeId= '" + rangeId + "' ";
		try {
			ResultSet result = dbUtil.getResulSet(query);
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
		int movieId = bookingDetails.getMovieId();
		int theatreId = bookingDetails.getTheatreId();
		int ticketsBooked = bookingDetails.getSeatCount();
		int bookingId = 0;
		String seatIdAndCost[] = bookingDetails.getCostAndSeatId();
		LocalTime showTiming = bookingDetails.getTime();
		LocalDate showDate = bookingDetails.getDate();
		String phone = bookingDetails.getPhone();
		String name = bookingDetails.getUserName();
		double totalCost = bookingDetails.getTotalCost();
		String seatIds = "";
		for (int seat = 0; seat < ticketsBooked; seat++) {
			String seatIdAndCostArray[] = seatIdAndCost[seat].split(" ");
			String seatId = seatIdAndCostArray[0] + " ";
			seatIds += seatId;
		}
		
		String query = "insert into bookings (movieId,theatreId, showtiming, showDate, ticketBooked, seatId) values('"
				+ movieId + "','" + theatreId + "','" + showTiming + "','" + showDate + "','" + ticketsBooked + "','"
				+ seatIds + "')";
		try {
			
			int columnUpdated = dbUtil.insertData(query);
			
			if (columnUpdated != 0)
				{
				log.info("bookings updated");
				String qry ="select bookingId from bookings order by bookingId desc limit 1;";
				ResultSet result = dbUtil.getResulSet(qry);
				while(result.next())
				bookingId = result.getInt("bookingId");log.info("bookingId "+ bookingId);
				String qy = "insert into userdetails values('"+phone+"','"+name+"','"+bookingId+"','"+totalCost+"')";
				columnUpdated=dbUtil.insertData(qy);
				if(columnUpdated!=0)check = true;
				}
			else
				log.warn("value already in the database");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return check;
	}

	
	@Override
	public TicketsDetails getTicketDetails() {
		TicketsDetails ticketsDetails = new TicketsDetails();
		String query = "select * from ticketreport where bookingId = (select bookingId from bookings order by bookingId desc limit 1) ";
		try {
			ResultSet resultSet = dbUtil.getResulSet(query);
			while(resultSet.next())
			{
				String fullName = resultSet.getString("fullName");
				String phone = resultSet.getString("phone");
				int bookingId = resultSet.getInt("bookingId");
				String movieName = resultSet.getString("movieName");
				LocalTime showTiming = LocalTime.parse(resultSet.getTime("showTiming").toString());
				LocalDate showDate = LocalDate.parse(resultSet.getDate("showDate").toString());
				int ticketBooked = resultSet.getInt("ticketBooked");
				String seatId = resultSet.getString("seatId");
				double totalCost = resultSet.getDouble("totalCost");
				
				ticketsDetails.setBookingId(bookingId);
				ticketsDetails.setFullName(fullName);
				ticketsDetails.setMovieName(movieName);
				ticketsDetails.setPhone(phone);
				ticketsDetails.setSeatId(seatId);
				ticketsDetails.setShowDate(showDate);
				ticketsDetails.setShowTiming(showTiming);
				ticketsDetails.setTicketBooked(ticketBooked);
				ticketsDetails.setTotalCost(totalCost);
			}
		}catch(Exception e)
		{
			log.info(e.getMessage());
			e.printStackTrace();
		}
		return ticketsDetails;
	}

}
