package com.epam.bms.main;

import com.epam.bms.services.PrintServices;

public class applicationRunnner {
	public static void main(String args[]) throws Exception {
		InputReader inputRead = new InputReader();
		PrintServices print = new PrintServices();

		print.printMsg("Select your choice of city.");
		print.showAvailableCities();
		String cityId = inputRead.readCityId();

		print.printMsg("Select your areacode.");
		print.printAreaPinInCity(cityId);
		String pin = inputRead.readPin();

		print.printMsg("Available movies at your locations are ");
		print.printMoviesAtLocation(pin);
		print.printMsg("Select the movieId to get the theatre showing the movie.");
		String movieId = inputRead.readMovieId();

		print.printMsg("Select the theatreId.");
		print.printTheatreListByMovie(movieId);
		String theatreId = inputRead.readTheatreId();

		print.printMsg("select the date");
		print.printAvailableDates();
		int dateId = inputRead.readDate();
		
		print.printMsg("Select show timing.");
		print.printShowTiming(theatreId, dateId);
		int showId = inputRead.readShowId();
		
		print.printPriceRanges();
	}
}