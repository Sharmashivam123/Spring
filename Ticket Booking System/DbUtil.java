package booking;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class DbUtil implements Data {
	private Movie movie1, movie2, movie3, movie4, invalidMovie;
	private List<Movie> movieList1, movieList2;
	private Location location1, location2, location3, location4;
	private List<Theatre> theatreMovie1, theatreMovie2, theatreMovie3, theatreMovie4;
	private List<Location> listLocation;
	private Map<String, Integer> rangeOfSeat;
	private Map<Movie, List<Theatre>> theatreByMovie;	
	
	DbUtil()
	{
		listLocation = new ArrayList<Location>();
		rangeOfSeat = new HashMap<String, Integer>();
		theatreByMovie = new HashMap<Movie, List<Theatre>>();
	}
	
	public void createMovieList()
	{
		movie1 = new Movie();
		movie1.setMovieName("War");
		
		movie2 = new Movie();
		movie2.setMovieName("Saaho");
		
		movie3 = new Movie();
		movie3.setMovieName("Joker");
		
		movie4 = new Movie();
		movie4.setMovieName("Narsimha");
		
		movieList1 = new ArrayList<>();
		movieList1.addAll(Arrays.asList(movie1, movie2, movie3, movie4));
		
		movieList2 = new ArrayList<>();
		movieList2.addAll(Arrays.asList(movie1, movie2, movie4));
	}
	
	
	public void addMoviesByPin()
	{
		createMovieList();
		location1 = new Location();
		location1.setPin(500081);
		location1.setMovieList(movieList1);
		
		location2 = new Location();
		location2.setPin(500082);
		location2.setMovieList(movieList1);
		
		location3 = new Location();
		location3.setPin(500083);
		location3.setMovieList(movieList2);
		
		location4 = new Location();
		location4.setPin(500084);
		location4.setMovieList(movieList2);
	}
	
	@Override
	public void setLocation()
	{
		addMoviesByPin();
		listLocation.addAll(Arrays.asList(location1, location2, location3, location4));
	}
	
	public void addTheatre()
	{
		Theatre theatre1 = new Theatre("PVR cyberabad");
		LocalTime time1=LocalTime.of(14, 00);
		theatre1.setMovieTime(time1);
		theatre1.setId(1);
		
		Theatre theatre2 = new Theatre("PVR Cinemas");
		LocalTime time2=LocalTime.of(13, 15);
		theatre2.setMovieTime(time2);
		theatre2.setId(2);
		
		Theatre theatre3=new Theatre("PVR Galleria Mall");
		LocalTime time3=LocalTime.of(17, 00);
		theatre3.setMovieTime(time3);
		theatre3.setId(3);
		
		Theatre theatre4=new Theatre("BR Hitech Theatre");
		LocalTime time4=LocalTime.of(21, 00);
		theatre4.setMovieTime(time4);
		theatre4.setId(4);
		
		theatreMovie1 = new ArrayList<Theatre>();
		theatreMovie1.addAll(Arrays.asList(theatre1, theatre2, theatre3, theatre4));
		theatreMovie2 = new ArrayList<Theatre>();
		theatreMovie2.addAll(Arrays.asList(theatre1, theatre2, theatre3, theatre4));
		theatreMovie3 = new ArrayList<Theatre>();
		theatreMovie3.addAll(Arrays.asList(theatre1, theatre2, theatre3, theatre4));
		theatreMovie4 = new ArrayList<Theatre>();
		theatreMovie4.addAll(Arrays.asList(theatre1, theatre2, theatre3, theatre4));
	}
	
	public void setTheatreByMovie()
	{
		addTheatre();
		theatreByMovie.put(movie1, theatreMovie1);
		theatreByMovie.put(movie2, theatreMovie2);
		theatreByMovie.put(movie3, theatreMovie3);
		theatreByMovie.put(movie4, theatreMovie4);
		
	}
	
	@Override
	public void setRangeOfSeat()
	{
		rangeOfSeat = new HashMap<String, Integer>();
		rangeOfSeat.put("Silver", 100);
		rangeOfSeat.put("Gold", 150);
		rangeOfSeat.put("Platinum", 200);
	}

	

	@Override
	public List<Location> getLocation() {
		return listLocation;
	}

	
	@Override
	public Map<String, Integer> getRangeOfSeat() {
		return rangeOfSeat;
	}


	@Override
	public List<Theatre> getTheatreByMovie(Movie movie) {
		List<Theatre> theatreList = null;
		for(Map.Entry<Movie, List<Theatre>> element: theatreByMovie.entrySet())
		{
			if(element.getKey().getMovieName().equals(movie.getMovieName()))theatreList=element.getValue();
		}
		
		return theatreList;
	}

	public boolean validatePin(Integer pin) {
		List<Integer> listPin = listLocation.stream().map(location->location.getPin()).collect(Collectors.toList());
		if(listPin.contains(pin))return true;
		return false;
	}
	
	public List<Movie> getMoviesByPin(int pin)
	{
		for(Location location:listLocation)
		{
			if(location.getPin()==pin)
				return location.getMoviesList();
		}
		return null;
	}

	public int calculatePrice(int price, int noofSeats) {		
		return price*noofSeats ;
	}

}
