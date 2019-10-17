package com.epam.bms.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.epam.bms.services.ValidationService;
import com.epam.bms.services.Calculation;
import com.epam.bms.services.PrintServices;

class BookingTicket {

	private static final Logger log = Logger.getLogger(BookingTicket.class);
	private static ValidationService validate = new ValidationService();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) throws Exception {
		Calculation calculation = new Calculation();

		try {
			BookingTicket booking = new BookingTicket();
			PrintServices show = new PrintServices();
			log.info("Welcome to ticket Booking System.\n\n");

			show.printLocation();
			String pin = booking.readPin();
			show.printMovieAtLocation(pin);

			String movieName = booking.readMovieName(pin);
			show.printTheatreAtMovie(movieName);

			log.info("select the theatreId acalculationording to your timing ");
			booking.readId();
			show.printPriceRange();

			booking.processTransaction(calculation);
		} catch (Exception e) {
			log.warn("Error at " + e.getMessage());
			throw new Exception();
		}
	}

	private void processTransaction(Calculation calculation) throws IOException {
		boolean check = false;
		while(check == false) {
			
			log.info("\nChoose the price range you want and no of tickets with space between them.\n");
			String priceandticket[] = reader.readLine().split(" ");
			if(priceandticket.length < 2 || !priceandticket[0].matches("^[0-9]+$") || !priceandticket[1].matches("^[0-9]+$")) {
				check = false;
				continue;
			}
			int price = Integer.parseInt(priceandticket[0]);
			int tickets = Integer.parseInt(priceandticket[1]);
			log.info("\n Total price for your " + tickets + " ticket is " + calculation.calculatePrice(price, tickets));
			check = true;
		}
	}

	private String readPin() throws IOException {
		boolean check = false;
		String pin = "";
		while (!check) {
			pin = reader.readLine();
			if (pin.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validatePin(pin))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		return pin;
	}

	private String readMovieName(String pin) throws IOException {
		boolean check = false;
		String movieName = "";
		while (!check) {
			movieName = reader.readLine();
			if (movieName.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validateMovieName(movieName, pin))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		return movieName;
	}

	private void readId() throws IOException {
		boolean check = false;
		int id = 0;
		String pid = "";
		while (!check) {
			pid = reader.readLine();
			if (pid.equalsIgnoreCase("x"))
				System.exit(0);
			id = Integer.parseInt(pid);
			if (!validate.validateId(id))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		return ;
	}

}
