package booking;

import java.util.List;
import java.util.Map;

interface Data {

	public void setLocation();

	public List<Location> getLocation();

	public void setRangeOfSeat();

	public Map<String, Integer> getRangeOfSeat();

	public void setTheatreByMovie();

	public List<Theatre> getTheatreByMovie(Movie movie);

	public boolean validatePin(Integer pin);

	public List<Movie> getMoviesByPin(Integer pin);

}
