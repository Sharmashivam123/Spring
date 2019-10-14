package com.epam.bms.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import com.epam.bms.main.CustomHandler;
import com.epam.bms.models.Location;
import com.epam.bms.models.Movie;
import com.epam.bms.util.Data;
import com.epam.bms.util.dataImpl;

public class Administrator {

	private static final Logger log = Logger.getLogger("  skidjfnijwoeaf ");
	Data data = new dataImpl();

	public void callLogger(Logger log) {
		log.setUseParentHandlers(false);
		CustomHandler customhandler = new CustomHandler();
		ConsoleHandler consolehandler = new ConsoleHandler();
		consolehandler.setFormatter(customhandler);
		log.addHandler(consolehandler);
	}

	public boolean validatePin(String pin) {
		String pattern = "^[0-9]+$";
		if (!pin.matches(pattern)) {
			return false;
		} else
			return true;
	}

	public boolean validateMovieName(String movieName, String pin) {
		List<Movie> list = data.getMovieListByPin(Integer.parseInt(pin));
		for (Movie m : list) {
			if (m.getMovieName().equals(movieName))
				return true;
		}
		return false;

	}

	public boolean validateId(int id) {
		if (id == 1 || id == 2 || id == 3 || id == 4) {
			return true;
		} else
			return false;
	}

}
