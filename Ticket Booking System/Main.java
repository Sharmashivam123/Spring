package booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Main {
	static Integer pin;
	static int id;
	static List<Movie> moviesAtLocation;
	static Movie movie;
	static List<Theatre> theatreByMovie;
	static Map<String, Integer> rangeOfSeat;
	static Integer price = 0, totalPrice = 0, noofSeats = 0;
	static String input[];

	public static void main(String[] args) throws IOException {
		try {
			Logger console = Logger.getLogger("");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			DbUtil db = new DbUtil();
			db.setLocation();
			db.setTheatreByMovie();
			db.setRangeOfSeat();
			console.info("Ticket Booking System\n");
			console.info("Enter the location from available pincodes.\n");
			db.getLocation().stream().map(location -> location.getPin()).forEach(pin -> console.info(pin + " " + "\n"));
			console.info("Enter the pin : ");
			pin = Integer.parseInt(reader.readLine());
			if (!db.validatePin(pin))
				throw new Exception("Invalid Input");

			console.info("Movies on the current Location are \n");
			moviesAtLocation = db.getMoviesByPin(pin);
			if (moviesAtLocation == null)
				throw new Exception("Invalid movie name");
			else {
				moviesAtLocation.stream().map(movie -> movie.getMovieName())
						.forEach(movie -> console.info(movie + " "));
				console.info(" \n ");
			}
			console.info("\\n Enter the movie name from above movies: ");
			movie = new Movie();
			String movieSelected = reader.readLine();
			movie.setMovieName(movieSelected);
			console.info("Theatres showing this movie are \n ");
			theatreByMovie = db.getTheatreByMovie(movie);
			if (theatreByMovie == null)
				throw new Exception("Invalid Input");
			for (Theatre t : theatreByMovie)
				console.info(t.getTheatreId() + " " + t.getTheatreName() + "  " + t.getMovieTime() + " \n ");

			console.info("select the theatreId according to your timing ");
			id = Integer.parseInt(reader.readLine());

			if (id == 1 || id == 2 || id == 3 || id == 4) {
				rangeOfSeat = db.getRangeOfSeat();
			} else
				throw new Exception("Invalid Input");

			console.info("Select your price range and no of ticket with space between them");

			for (Map.Entry<String, Integer> ele : rangeOfSeat.entrySet())
				console.info(ele.getKey() + " " + ele.getValue() + " \n ");

			input = reader.readLine().split(" ");
			price = Integer.parseInt(input[0]);
			noofSeats = Integer.parseInt(input[1]);

			totalPrice = db.calculatePrice(price, noofSeats);
			console.info("Total Price is " + totalPrice);

		} catch (Exception e) {
			System.out.println("Invalid price value or seat count ");
		}
	}
}
