package com.epam.bms.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.bms.bean.Movie;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/Movie")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Services services = new Services();
		PrintWriter out = response.getWriter();
		BookingDetails bookingDetails = BookingDetails.getInstance();
		out.println("Available movies at your locations are ");
		List<Movie> listMovie = services.getMoviesAtLocation();
		out.println("Select the movieId to get the theatre showing the movie.");
		listMovie.stream().forEach(movie -> out.println(movie.getMovieId() + " " + movie.getMovieName()));
		String movieId = request.getParameter("movieId");
		bookingDetails.setMovieId(Integer.parseInt(movieId));
		if (bookingDetails.getMovieId() != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/Theatre?theatreId=1");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/Theatre");
		rd.include(request, response);
	}
}
