package com.epam.bms.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.epam.bms.models.Location;
import com.epam.bms.services.PriceCalculation;
import com.epam.bms.services.PrintServices;

class BookingTicket {

	private static final Logger log = Logger.getLogger(BookingTicket.class);
	
	public static void main(String args[]) throws Exception {
		PriceCalculation calculation = new PriceCalculation();

		try {
			InputReader reader = new InputReader();
			PrintServices print = new PrintServices();
			log.info("Welcome to ticket Booking System.\n\n");
			
			print.printCity();
			String cityId = reader.readCity();
			List<Location> listLocation = print.printLocation(cityId);
			String pin = reader.readPin(cityId);
			print.printMovieAtLocation(pin);

			String movieName = reader.readMovieName(pin);
			print.printTheatreAtMovie(movieName);

			log.info("select the theatreId acalculationording to your timing ");
			reader.readId();
			print.printPriceRange();

			reader.processTransaction(calculation);
		} catch (Exception e) {
			log.warn("Error at " + e.getMessage());
			throw new Exception();
		}
	}

	

}
