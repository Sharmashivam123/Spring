package booking;

import java.util.List;

public class Location {
	private int pin;
	private List<Movie> movieList;
	Location()
	{
		
	}
	
	public List<Movie> getMoviesList()
	{
		return movieList;
	}
	
	public void setMovieList(List<Movie> list)
	{
		movieList=list;
	}
	
	public int getPin()
	{
		return pin;
	}
	
	public void setPin(int pin)
	{
		this.pin=pin;
	}
	
}
