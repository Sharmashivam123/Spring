package com.epam.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ExceptionHandler.Exception.ServiceLayerException;
import com.epam.bean.BookingDetails;
import com.epam.bean.Movie;
import com.epam.dao.MovieDao;
import com.epam.services.MovieServices;
import com.epam.util.ApplicationConstants;

@Service
public class MovieServicesImpl implements MovieServices {
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private BookingDetails bookingDetails;

	public List<Movie> getMoviesAtLocation() {
		int locationId = bookingDetails.getPincode();
		List<Movie> listMovie = movieDao.findAllByLocationId(locationId);
		Optional.ofNullable(listMovie).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));
		return listMovie;
	}
}
