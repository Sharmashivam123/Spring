package com.epam.bms.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.epam.bms.models.Location;
import com.epam.bms.models.Movie;
import com.epam.bms.util.TraverseData;
import com.epam.bms.util.TraverseDataImpl;


public class PrintServices {
	
	private static final Logger log = Logger.getLogger(PrintServices.class);
	private TraverseData data = new TraverseDataImpl();

	public void printLocation() {

		log.info("Please enter your pin code.\n");
		List<Location> list = data.getLocation();
		list.parallelStream().forEach(location -> log.info(" " + location.getPin() + " "));
		log.info("\n");
	}

	public void printMovieAtLocation(String pin) throws Exception {
		try {

			int pincode = Integer.parseInt(pin);
			log.info("\n List of movies showing at this location are .. \n");
			List<Movie> moviesList = data.getMovieListByPin(pincode);
			if (moviesList == null)
				throw new Exception("No movies at this location");
			else
				moviesList.stream().forEach(movie -> log.info("   " + movie.getMovieName() + "\n"));
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new Exception();
		}
	}

	public void printTheatreAtMovie(String movieName) throws Exception {
		try {
			log.info("\n Theatre showing this moving are \n");
			Movie movie = new Movie();
			movie.setMovieName(movieName);
			data.getTheatreListByMovie(movie).stream().forEach(obj -> log
					.info(" " + obj.getTheatreId() + " " + obj.getTheatreName() + " " + obj.getMovieTime() + "\n "));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public void printPriceRange() {
		Map<String, Integer> range = data.getRangeOfSeat();
		for (Entry<String, Integer> map : range.entrySet())
			log.info("\n" + map.getKey() + " - " + map.getValue() + " \n ");
	}
}
