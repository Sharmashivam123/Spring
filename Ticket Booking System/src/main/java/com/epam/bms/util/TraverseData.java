package com.epam.bms.util;
import java.util.List;
import java.util.Map;

import com.epam.bms.models.Location;
import com.epam.bms.models.Theatre;
import com.epam.bms.models.Movie;

public interface TraverseData {

	public void setLocation();

	public List<Location> getLocation();

	public void setRangeOfSeat();

	public Map<String, Integer> getRangeOfSeat();

	public void setTheatreListByMovie();

	public List<Theatre> getTheatreListByMovie(Movie movie);

	public List<Movie> getMovieListByPin(Integer pin);
	

}
