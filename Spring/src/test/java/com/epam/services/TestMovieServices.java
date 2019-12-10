package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.bean.BookingDetails;
import com.epam.bean.Movie;
import com.epam.dao.MovieDao;
import com.epam.services.servicesImpl.MovieServicesImpl;

class TestMovieServices {
	@InjectMocks
	MovieServicesImpl mock;
	@Mock
	private MovieDao movieDao;
	@Mock
	private BookingDetails bookingDetails;

	@Test
	public void testMovie() {
		MockitoAnnotations.initMocks(this);
		when(bookingDetails.getPincode()).thenReturn(500081);
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

		List<Movie> movieList = Arrays.asList(movie1, movie2, movie3, movie4);
		when(movieDao.findAllByLocationId(500081)).thenReturn(movieList);
		assertEquals(movieList, movieDao.findAllByLocationId(500081));
	}
}
