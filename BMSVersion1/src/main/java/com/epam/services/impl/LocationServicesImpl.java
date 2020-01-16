package com.epam.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.Location;
import com.epam.bean.Movie;
import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.repo.LocationDao;
import com.epam.repo.MovieDao;
import com.epam.services.LocationServices;
import com.epam.util.ApplicationConstants;

@Service
public class LocationServicesImpl implements LocationServices {
	@Autowired
	private LocationDao areaDao;
	@Autowired
	private MovieDao movieDao;

	public List<Location> getAreaPinInCity(int cityId) {

		return Optional.ofNullable(areaDao.findAllByCityId(cityId)).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));

	}

	@Override
	public List<Location> getAll() {
		return (List<Location>) areaDao.findAll();
	}

	@Override
	public void delete(int locationId) {
		areaDao.deleteById(locationId);
	}

	@Override
	public Location addLocation(Location location, int[] movies) {
		List<Movie> movieList = new ArrayList<Movie>();
		int n = movies.length;
		for (int i = 0; i < n; i++) {
			Optional<Movie> movie = movieDao.findById(movies[i]);
			if (movie.isPresent())
				movieList.add(movie.get());
		}
		location.setMovieList(movieList);
		return areaDao.save(location);
	}

	@Override
	public void update(int locationId, String locationName, int[] movies) {
		List<Movie> movieList = new ArrayList<Movie>();
		int n = movies.length;
		for (int i = 0; i < n; i++) {
			Optional<Movie> movie = movieDao.findById(movies[i]);
			if (movie.isPresent())
				movieList.add(movie.get());
		}
		new Location();
		Optional<Location> optional = areaDao.findById(locationId);
		if (optional.isPresent()) {
			Location location = optional.get();
			location.setMovieList(movieList);
			location.setLocationName(locationName);
			areaDao.save(location);
		}
	}
}
