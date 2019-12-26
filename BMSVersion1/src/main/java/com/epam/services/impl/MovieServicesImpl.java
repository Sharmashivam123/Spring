package com.epam.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.Movie;
import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.repo.MovieDao;
import com.epam.services.MovieServices;
import com.epam.util.ApplicationConstants;

@Service
public class MovieServicesImpl implements MovieServices {
	@Autowired
	private MovieDao movieDao;

	public List<Movie> getMoviesAtLocation(int locationId) {
		return Optional.ofNullable(movieDao.findAllByLocationId(locationId)).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));
	}

	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) movieDao.findAll();
	}

	@Override
	public Movie update(Movie movie) {
		Optional<Movie> optional = movieDao.findById(movie.getMovieId());
		if (optional.isPresent()) {
			movie = movieDao.save(movie);
		}
		return movie;
	}

	public void delete(int movieId) {
		movieDao.deleteById(movieId);
	}

	@Override
	public Movie addMovie(Movie movie) {
		return movieDao.save(movie);
	}

}
