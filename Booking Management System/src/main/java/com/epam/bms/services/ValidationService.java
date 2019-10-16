package com.epam.bms.services;

import java.util.List;
import com.epam.bms.models.Location;
import com.epam.bms.models.Movie;
import com.epam.bms.util.Data;
import com.epam.bms.util.DataImpl;

public class ValidationService {

	private Data data = new DataImpl();

	public boolean validatePin(String pin) {
		boolean check = true;
		String pattern = "^[0-9]+$";
		if (!pin.matches(pattern)) {
			check = false;
		} else
			{
				int pincode = Integer.parseInt(pin);
				check = containsPin(pincode);
			}
		return check;
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
		if (id <= 4 && id > 0) {
			return true;
		} else
			return false;
	}

	
	public boolean containsPin(int pin)
	{
		boolean check = false;
		List<Location> list = data.getLocation();
		for (Location loc : list)
		{
			if(loc.getPin() == pin)
			{
				check = true;
				break;
			}
			check = false;
		}
		return check;
	}
}
