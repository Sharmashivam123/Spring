package com.epam.util;

public class Constants {

	public static final String MOVIE_BY_LOCATION_QUERY = "SELECT * from movie"
			+ " WHERE movieId IN (SELECT movieId from moviebylocation WHERE pincode =?1)";
	public static final String SELECTED_SEATID_QUERY = "select seatId from bookings "
			+ "where movieId=?1 and theatreId=?2 and showtiming=?3 and showdate=?4";

	public static final String SHOW_TIMING_OF_MOVIE_QUERY = "select * from showtiming \r\n"
			+ "where timingId = (select timingId from theatrebymovie \r\n" + "where theatreId =?1 and movieId =?2)";
	public static final String THEATRE_BY_MOVIE_QUERY = "select * from theatre "
			+ "where theatreId in (SELECT theatreId from theatrebymovie WHERE movieId =?1)";

	public static final String CITY_URL = "http://localhost:8083/rstcity";
	public static final String LOCATION_URL = "http://localhost:8083/rstlocation";
	public static final String MOVIE_URL = "http://localhost:8083/rstmovie";
	public static final String THEATRE_URL = "http://localhost:8083/rsttheatre";
	public static final String DATE_URL = "http://localhost:8083/rstdate";
	public static final String SHOW_TIME_URL = "http://localhost:8083/rsttiming12";
	public static final String SEATRANGE_URL = "http://localhost:8083/rstseats";
	public static final String BOOKING_URL = "http://localhost:8083/rstbooking";
	public static final String TICKET_URL = "http://localhost:8083/rsttickets";
}
