package com.epam.bms.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.bms.bean.Movie;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

class TestMovie {
	@InjectMocks
	CityServlet mock;
	
	@Mock
	DBOperation dBOperation;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testDoGet() throws Exception
	{
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response=Mockito.mock(HttpServletResponse.class);
		Services services = Mockito.mock(Services.class);
		 RequestDispatcher rd=Mockito.mock(RequestDispatcher.class);
		 BookingDetails bookingDetails = Mockito.mock(BookingDetails.class);
		 Mockito.when(request.getParameter("location")).thenReturn("500081");
		 bookingDetails.setPincode(Integer.parseInt("500081"));
		 Mockito.verify(bookingDetails).setPincode(Integer.parseInt("500081"));
		 Movie movie1 = new Movie();
			movie1.setMovieId(1);
			movie1.setMovieName("war");

			Movie movie2 = new Movie();
			movie2.setMovieId(2);
			movie2.setMovieName("joker");

			Movie movie3 = new Movie();
			movie3.setMovieId(3);
			movie3.setMovieName("housefull4");

			Movie movie4 = new Movie();
			movie4.setMovieId(4);
			movie4.setMovieName("terminator");

			List<Movie> expectedMovieList = Arrays.asList(movie1, movie2, movie3, movie4);
		 Mockito.when(dBOperation.getMovieListByAreaPin(500081)).thenReturn(expectedMovieList);
		 List<Movie> actualMovieList = services.getMoviesAtLocation();
		System.out.println(actualMovieList);
			request.setAttribute("movies", actualMovieList);
			Mockito.verify(request).setAttribute("movies", actualMovieList);
			 Mockito.when(request.getRequestDispatcher("/Error")).thenReturn(rd);
			 Mockito.when(request.getRequestDispatcher("Movie.jsp")).thenReturn(rd);
			new MovieServlet().doGet(request, response);
			 Mockito.verify(rd).forward(request, response);
		}

}
