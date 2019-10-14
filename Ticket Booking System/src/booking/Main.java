package booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class Main {
	static int id;

	static Map<String, Integer> rangeOfSeat;
	static Integer price = 0, totalPrice = 0, noofSeats = 0;
	static String input[];
	static Calculation cc = new Calculation();
	static Logger console;

	Main() {

	}

	public static void main(String[] args) throws IOException {
		Data db = new DbUtil();
		boolean check;
		int pin = 0;
		List<Movie> moviesAtLocation;
		List<Theatre> theatreByMovie;
		Movie movie;
		Main m = new Main();
		m.callLogger();
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			console.info("Ticket Booking System\n");
			console.info("Enter the location from available pincodes.\n");
			db.getLocation().stream().map(location -> location.getPin()).forEach(p -> console.info(p + " " + "\n"));
			console.info("Enter the pin : ");
			check = false;

			while (!check) {
				String qry = reader.readLine();
				if (qry.equalsIgnoreCase("done"))
					System.exit(0);
				pin = Integer.parseInt(qry);
				if (!db.validatePin(pin))
					console.info("Invalid Input.\n Sir Please select from above option or type DONE if Your are done.");
				else
					check = true;
			}

			console.info("Movies on the current Location are \n");
			moviesAtLocation = db.getMoviesByPin(pin);
			if (moviesAtLocation == null)
				throw new Exception("Invalid movie name");
			else {
				m.printAllMovies(moviesAtLocation);
			}
			console.info("\\n Enter the movie name from above movies: ");
			movie = new Movie();
			String movieSelected = reader.readLine();
			movie.setMovieName(movieSelected);

			theatreByMovie = db.getTheatreByMovie(movie);
			console.info("Theatres showing this movie are \n ");
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

			totalPrice = cc.calculatePrice(price, noofSeats);
			console.info("Total Price is " + totalPrice);

		} catch (Exception e) {
			console.info(e.getMessage());
			// System.out.println("Invalid price value or seat count ");
		}
	}

	void printAllMovies(List<Movie> list) {
		list.stream().map(movie -> movie.getMovieName()).forEach(movie -> console.info(movie + " "));
		console.info(" \n ");
	}

	void callLogger() {
		console = Logger.getLogger("gvhv");
		console.setUseParentHandlers(false);
		CustomHandler ch = new CustomHandler();
		ConsoleHandler consolehandler = new ConsoleHandler();
		consolehandler.setFormatter(ch);
		console.addHandler(consolehandler);
	}
}
