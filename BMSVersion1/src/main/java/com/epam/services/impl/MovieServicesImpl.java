package com.epam.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.Movie;
import com.epam.bean.Theatre;
import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.repo.MovieDao;
import com.epam.repo.TheatreDao;
import com.epam.services.MovieServices;
import com.epam.util.ApplicationConstants;

@Service
public class MovieServicesImpl implements MovieServices {
	@Autowired
	private MovieDao movieDao;

	@Autowired
	private TheatreDao theatreDao;

	public List<Movie> getMoviesAtLocation(int locationId) {
		return Optional.ofNullable(movieDao.findAllByLocationId(locationId)).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));
	}

	@Override
	public List<Movie> getAllMovies() {
		return (List<Movie>) movieDao.findAll();
	}

	public void delete(int movieId) {
		movieDao.deleteById(movieId);
	}

	@Override
	public Movie addMovie(Movie movie, int[] theatreSelected) {
		List<Theatre> theatreList = new ArrayList<>();
		int n = theatreSelected.length;
		for (int i = 0; i < n; i++) {
			Optional<Theatre> optional = theatreDao.findById(theatreSelected[i]);
			if (optional.isPresent())
				theatreList.add(optional.get());
		}
		movie.setTheatreList(theatreList);
		return movieDao.save(movie);
	}

	@Override
	public void update(int movieId, String movieName, int[] theatreSelected) {
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		List<Theatre> theatreList = new ArrayList<>();
		int n = theatreSelected.length;

		for (int i = 0; i < n; i++) {
			Optional<Theatre> optional = theatreDao.findById(theatreSelected[i]);
			if (optional.isPresent())
				theatreList.add(optional.get());
		}

		Optional<Movie> optional = movieDao.findById(movieId);
		if (optional.isPresent()) {
			movie.setMovieName(movieName);
			movie.setTheatreList(theatreList);
			movieDao.save(movie);
		}

	}

}
