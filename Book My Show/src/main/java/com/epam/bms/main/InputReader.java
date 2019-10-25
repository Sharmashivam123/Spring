package com.epam.bms.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.apache.log4j.Logger;

import com.epam.bms.util.ShowTimes;
import com.epam.bms.services.PrintServices;
import com.epam.bms.services.ValidationService;
import com.epam.bms.util.BookingDetails;

public class InputReader {
	private String city, pin;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ValidationService validate = new ValidationService();
	BookingDetails bookingDetails = BookingDetails.getInstance();
	private static final Logger log = Logger.getLogger(PrintServices.class);

	public String readCityId() throws Exception {
		boolean check = false;
		city = "";
		while (!check) {
			city = reader.readLine();
			if (city.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validateCity(city))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		return city;
	}

	public String readPin() throws IOException {
		boolean check = false;
		pin = "";
		while (!check) {
			pin = reader.readLine();
			if (pin.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validatePin(pin, city))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		return pin;
	}

	public int readMovieId() throws IOException {
		boolean check = false;
		String movie = "";
		while (!check) {
			movie = reader.readLine();
			if (movie.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validateMovieName(movie, pin))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		int movieId = Integer.parseInt(movie);
		bookingDetails.setMovieId(movieId);
		return movieId;
	}

	public void readTheatreId() throws IOException {
		boolean check = false;
		int movieId = bookingDetails.getMovieId();
		String theatreId = "";
		while (!check) {
			theatreId = reader.readLine();
			if (theatreId.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validateTheatreId(theatreId, movieId))
				log.info("\nChoose from available options only or enter 'x' to Exit ! \n");
			else
				check = true;
		}
		bookingDetails.setTheatreId(Integer.parseInt(theatreId));
	}

	public int readDate() throws IOException {
		boolean check = false;
		String date = "";
		while (!check) {
			date = reader.readLine();
			if (date.equalsIgnoreCase("x"))
				System.exit(0);
			if (date.matches("^[1-3]"))
				check = true;
			else
				log.info("\nChoose from available options only or enter 'x' to Exit ! \n");
		}
		int dateId = Integer.parseInt(date);
		LocalDate bookingDate = LocalDate.now().plusDays(dateId - 1);
		bookingDetails.setDate(bookingDate);
		return dateId;
	}

	public void readShowId() throws IOException {
		boolean check = false;
		String show = "";
		while (!check) {
			show = reader.readLine();
			if (show.equalsIgnoreCase("x"))
				System.exit(0);
			if (show.matches("^[1-9]"))
				check = validate.validateShow(show);
			else
				log.info("\nChoose from available options only or enter 'x' to Exit ! \n");
		}
		int showId = Integer.parseInt(show);
		ShowTimes time = ShowTimes.getInstatnce();
		Map<Integer, LocalTime> timeIndexMap = time.getAvailableShow();
		bookingDetails.setTime(timeIndexMap.get(showId));

	}

	public void readRangeId() throws IOException {
		boolean check = false;
		String range = "";
		while (!check) {
			range = reader.readLine();
			if (range.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validateRange(range))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		bookingDetails.setPriceRangeId(Integer.parseInt(range));
	}

	public void readSeatCount() throws IOException {
		boolean check = false;
		String numberOfTickets = "";
		while (!check) {
			numberOfTickets = reader.readLine();
			if (numberOfTickets.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validateSeatCount(numberOfTickets))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		bookingDetails.setSeatCount(Integer.parseInt(numberOfTickets));
	}

}
