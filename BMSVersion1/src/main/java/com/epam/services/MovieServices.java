package com.epam.services;

import java.util.List;

import com.epam.bean.Movie;

public interface MovieServices {
	public List<Movie> getMoviesAtLocation(int location);

	public List<Movie> getAllMovies();

	public Movie update(Movie movie);
	
	public Movie addMovie(Movie movie);

	public void delete(int movieId);
}
