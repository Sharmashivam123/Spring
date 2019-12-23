package com.epam.util;

public class Constants {
	private Constants() {
	}

	public static final String MOVIE_BY_LOCATION_QUERY = "SELECT * from movie"
			+ " WHERE movieId IN (SELECT movieId from moviebylocation WHERE pincode =?1)";
	public static final String SELECTED_SEATID_QUERY = "select seatId from bookings "
			+ "where movieId=?1 and theatreId=?2 and showtiming=?3 and showdate=?4";

	public static final String SHOW_TIMING_OF_MOVIE_QUERY = "select * from showtiming \r\n"
			+ "where timingId = (select timingId from theatrebymovie \r\n" + "where theatreId =?1 and movieId =?2)";
	public static final String THEATRE_BY_MOVIE_QUERY = "select * from theatre "
			+ "where theatreId in (SELECT theatreId from theatrebymovie WHERE movieId =?1)";

	public static final String CITY_URL = "http://localhost:8080/rest/rstcity";
	public static final String LOCATION_URL = "http://localhost:8080/rest/rstlocation/";
	public static final String MOVIE_URL = "http://localhost:8080/rest/rstmovie/";
	public static final String THEATRE_URL = "http://localhost:8080/rest/rsttheatre/";
	public static final String DATE_URL = "http://localhost:8080/rest/rstdate";
	public static final String SHOW_TIME_URL = "http://localhost:8080/rest/rsttiming12/";
	public static final String SEATRANGE_URL = "http://localhost:8080/rest/rstseats/";
	public static final String BOOKING_URL = "http://localhost:8080/rest/rstbooking";
	public static final String TICKET_URL = "http://localhost:8080/rest/rsttickets";
	public static final String GET_USER_URL = "http://localhost:8080/rest/rstuserinfo/";
	public static final String UPDATE_URL = "http://localhost:8080/rest/rstupdateuser";
	public static final String REGISTER_URL = "http://localhost:8080/rest/rstinsertuser";
	public static final String INDEX = "index";
	public static final String LOGIN = "login";
}
