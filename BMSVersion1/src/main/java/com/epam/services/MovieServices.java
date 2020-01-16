package com.epam.services;

import java.util.List;

import com.epam.bean.Movie;

public interface MovieServices {
	public List<Movie> getMoviesAtLocation(int location);

	public List<Movie> getAllMovies();

	public Movie addMovie(Movie movie, int[] theatreSelected);

	public void delete(int movieId);

	public void update(int movieId, String movieName, int[] theatreSelected);
}
