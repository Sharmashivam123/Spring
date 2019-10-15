package com.epam.bms.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.epam.bms.services.Administrator;
import com.epam.bms.services.Calculation;
import com.epam.bms.services.PrintServices;

class BookingTicket {

	private static final Logger log = Logger.getLogger("  skidjfnijwoeaf ");
	
	
	public static void main(String args[]) throws Exception
	{
		Calculation cc = new Calculation(); 
		String qry = null;
		boolean check = false;
		try {
			PrintServices show = new PrintServices();
			Administrator admin = new Administrator();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			admin.callLogger(log);
			log.info("Welcome to ticket Booking System.\n\n");
			show.printLocation();
			
			while (!check) {
				qry = reader.readLine();
				if(!admin.validatePin(qry))
					log.warning("\nChoose from available option only!\n");
				else check = true;	
			}
			
			show.printMovieAtLocation(qry);
			String movieName = reader.readLine();
			if(!admin.validateMovieName(movieName, qry))throw new Exception(" Insert from the available movies only");
			show.printTheatreAtMovie(movieName);
			
			log.info("select the theatreId according to your timing ");
			int id = Integer.parseInt(reader.readLine());
			
			if(!admin.validateId(id))
			throw new Exception("Insert the correct id");
			else
			show.printPriceRange();
			
			log.info("\nChoose the price range you want and no of tickets with space between them.\n");
			String priceandticket[] = reader.readLine().split(" ");
			int price = Integer.parseInt(priceandticket[0]);
			int tickets = Integer.parseInt(priceandticket[1]);
			log.info("\n Total price for your " + tickets + " ticket is " + cc.calculatePrice(price, tickets));
		}
		catch(Exception e)
		{
		   log.warning("Error at " + e.getMessage());
		   throw new Exception();
		}
		
		
	}


	
}

