package com.epam.services;

import java.util.List;

import com.epam.bean.Movie;

public interface MovieServices {
	public List<Movie> getMoviesAtLocation(int location);
}
