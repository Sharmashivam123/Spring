package com.epam.bms.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;

import com.epam.bms.services.PrintServices;
import com.epam.bms.services.ValidationService;

public class InputReader {
	private String city, pin, movieId, theatreId;
	int showId = 0, dateId = 0;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ValidationService validate = new ValidationService();
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

	public String readMovieId() throws IOException {
		boolean check = false;
		movieId = "";
		while (!check) {
			movieId = reader.readLine();
			if (movieId.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validateMovieName(movieId, pin))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		return movieId;
	}

	public String readTheatreId() throws IOException {
		boolean check = false;
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
		return theatreId;
	}

	public int readShowTime() throws IOException {
		boolean check = false;
		String timeId = "";
		while (!check) {
			timeId = reader.readLine();
			if (timeId.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validateShowTime(theatreId, timeId))
				log.info("\n Choose from available options only or enter 'x' to Exit ! \\n");
			else
				check = true;
		}
		return Integer.parseInt(timeId);
	}

	public int readDate() throws IOException {
		boolean check = false;
		String date = "";
		while (!check) {
			date = reader.readLine();
			if (date.equalsIgnoreCase("x"))
				System.exit(0);
			if(date.matches("^[1-3]"))
				check = true;
			else
				log.info("\nChoose from available options only or enter 'x' to Exit ! \n");
		}
		dateId = Integer.parseInt(date);
		return dateId;
	}

	public int readShowId() throws IOException {
		boolean check = false;
		String show = "";
		while (!check) {
			show = reader.readLine();
			if (show.equalsIgnoreCase("x"))
				System.exit(0);
			if(show.matches("^[1-9]"))
				check = validate.validateShow(show);
			else
				log.info("\nChoose from available options only or enter 'x' to Exit ! \n");
		}
		dateId = Integer.parseInt(show);
		
		return showId;
	}


}
