package com.epam.bms.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.epam.bms.models.Movie;
import com.epam.bms.models.Theatre;
import com.epam.bms.models.Location;

public class InitializingDataValues {
	
	private Movie movie1, movie2, movie3, movie4;
	private List<Movie> movieList1, movieList2;
	
	public void createMovieList() {
		movie1 = new Movie();
		movie1.setMovieName("War");

		movie2 = new Movie();
		movie2.setMovieName("Saaho");

		movie3 = new Movie();
		movie3.setMovieName("Joker");

		movie4 = new Movie();
		movie4.setMovieName("Narsimha");

		movieList1 = new ArrayList<Movie>();
		movieList1.addAll(Arrays.asList(movie1, movie2, movie3, movie4));

		movieList2 = new ArrayList<Movie>();
		movieList2.addAll(Arrays.asList(movie1, movie2, movie4));
	}
	
	public List<Location> addMoviesAtPin(List<Location> list) {
		createMovieList();
		Location location1 = new Location();
		location1.setPin(500081);
		location1.setMovieList(movieList1);

		Location location2 = new Location();
		location2.setPin(500082);
		location2.setMovieList(movieList1);

		Location location3 = new Location();
		location3.setPin(500083);
		location3.setMovieList(movieList2);

		Location location4 = new Location();
		location4.setPin(500084);
		location4.setMovieList(movieList2);
		
		list.addAll(Arrays.asList(location1, location2, location3, location4));
		return list;
	}
	
	
	public Map<Movie, List<Theatre>> addTheatreListByMovie(Map<Movie, List<Theatre>> map) {
		Theatre theatre1 = new Theatre("PVR cyberabad");
		LocalTime time1 = LocalTime.of(14, 00);
		theatre1.setMovieTime(time1);
		theatre1.setId(1);

		Theatre theatre2 = new Theatre("PVR Cinemas");
		LocalTime time2 = LocalTime.of(13, 15);
		theatre2.setMovieTime(time2);
		theatre2.setId(2);

		Theatre theatre3 = new Theatre("PVR Galleria Mall");
		LocalTime time3 = LocalTime.of(17, 00);
		theatre3.setMovieTime(time3);
		theatre3.setId(3);

		Theatre theatre4 = new Theatre("BR Hitech Theatre");
		LocalTime time4 = LocalTime.of(21, 00);
		theatre4.setMovieTime(time4);
		theatre4.setId(4);

		List<Theatre> theatreMovie1 = new ArrayList<Theatre>();
		theatreMovie1.addAll(Arrays.asList(theatre1, theatre2, theatre3, theatre4));
		List<Theatre> theatreMovie2 = new ArrayList<Theatre>();
		theatreMovie2.addAll(Arrays.asList(theatre1, theatre2, theatre3, theatre4));
		List<Theatre> theatreMovie3 = new ArrayList<Theatre>();
		theatreMovie3.addAll(Arrays.asList(theatre1, theatre2, theatre3, theatre4));
		List<Theatre> theatreMovie4 = new ArrayList<Theatre>();
		theatreMovie4.addAll(Arrays.asList(theatre1, theatre2, theatre3, theatre4));
		map.put(movie1, theatreMovie1);
		map.put(movie2, theatreMovie2);
		map.put(movie3, theatreMovie3);
		map.put(movie4, theatreMovie4);
		
		return map;

	}

	public List<Movie> getListOfMovies(List<Location> listLocation, int pin) {
		for (Location location : listLocation) {
			if (location.getPin() == pin)
				return location.getMoviesList();
		}
		return null;
	}
	
	public Map<String, Integer> addSeatRanges(Map<String, Integer> rangeOfSeat)
	{
		rangeOfSeat.put("Silver", 100);
		rangeOfSeat.put("Gold", 150);
		rangeOfSeat.put("Platinum", 200);
		
		return rangeOfSeat;
	}
}
