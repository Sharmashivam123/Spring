package com.epam.bms.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.epam.bms.services.PrintServices;
import com.epam.bms.services.ValidationService;

public class InputReader {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	ValidationService validate = new ValidationService();
	private static final Logger log = Logger.getLogger(PrintServices.class);

	public String readCityId() throws Exception {
		boolean check = false;
		String city = "";
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

	public String readPin(String cityId) throws IOException {
		boolean check = false;
		String pin = "";
		while (!check) {
			pin = reader.readLine();
			if (pin.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validatePin(pin, cityId))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		return pin;
	}

	public String readMovieId(String pin) throws IOException {
		boolean check = false;
		String movieId = "";
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

	public String readTheatreId(String movieId) throws IOException {
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

}
