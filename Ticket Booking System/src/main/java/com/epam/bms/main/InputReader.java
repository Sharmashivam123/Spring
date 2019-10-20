package com.epam.bms.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.epam.bms.services.PriceCalculation;
import com.epam.bms.services.ValidationService;
import org.apache.log4j.Logger;

public class InputReader {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static ValidationService validate = new ValidationService();
	private static final Logger log = Logger.getLogger(BookingTicket.class);

	void processTransaction(PriceCalculation calculation) throws IOException {
		boolean check = false;
		while (check == false) {

			log.info("\nChoose the price range you want and no of tickets with space between them.\n");
			String priceandticket[] = reader.readLine().split(" ");
			if (priceandticket.length < 2 || !priceandticket[0].matches("^[0-9]+$")
					|| !priceandticket[1].matches("^[0-9]+$")) {
				check = false;
				continue;
			}
			int price = Integer.parseInt(priceandticket[0]);
			int tickets = Integer.parseInt(priceandticket[1]);
			if (!validate.validatePrice(price))
				continue;
			log.info("\n Total price for your " + tickets + " ticket is " + calculation.calculatePrice(price, tickets));
			check = true;
		}
	}

	String readPin(String cityId) throws IOException {
		boolean check = false;
		String pin = "";
		while (!check) {
			pin = reader.readLine();
			if (pin.equalsIgnoreCase("x"))
				System.exit(0);
			if (!validate.validatePin(pin,cityId))
				log.info("\nChoose from available option only or Enter 'X' to EXIT !\n");
			else
				check = true;
		}
		return pin;
	}

	String readMovieName(String pin) throws IOException {
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

	void readId() throws IOException {
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
		return;
	}

	public String readCity() throws IOException {
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
}
