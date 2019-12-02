package com.epam.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bean.BookingDetails;
import com.epam.bean.Movie;
import com.epam.services.RestClientService;

@SpringBootTest
@AutoConfigureMockMvc
class TestMovieController {
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookingDetails bookingDetails;
	@MockBean
	private RestClientService service;

	@Test
	public void testMovie() throws Exception {
		doNothing().when(bookingDetails).setPincode(500081);
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

		when(service.getAllMoviesAtLocation()).thenReturn(movieList);
		mockmvc.perform(get("/movie?location=1")).andExpect(status().isOk())
				.andExpect(model().attribute("movies", movieList)).andExpect((forwardedUrl("movie.jsp")));
	}
}
