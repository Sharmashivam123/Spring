package com.epam.bms.main;

import org.apache.log4j.Logger;

import com.epam.bms.services.PriceCalculation;
import com.epam.bms.services.PrintServices;

class BookingTicket {

	private static final Logger log = Logger.getLogger(BookingTicket.class);
	
	public static void main(String args[]) throws Exception {
		PriceCalculation calculation = new PriceCalculation();

		try {
			InputReader reader = new InputReader();
			PrintServices show = new PrintServices();
			log.info("Welcome to ticket Booking System.\n\n");

			show.printLocation();
			String pin = reader.readPin();
			show.printMovieAtLocation(pin);

			String movieName = reader.readMovieName(pin);
			show.printTheatreAtMovie(movieName);

			log.info("select the theatreId acalculationording to your timing ");
			reader.readId();
			show.printPriceRange();

			reader.processTransaction(calculation);
		} catch (Exception e) {
			log.warn("Error at " + e.getMessage());
			throw new Exception();
		}
	}

	

}
