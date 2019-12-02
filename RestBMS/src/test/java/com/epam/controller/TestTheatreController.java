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
import com.epam.bean.Theatre;
import com.epam.services.RestClientService;

@SpringBootTest
@AutoConfigureMockMvc
class TestTheatreController {
	@Autowired
	private MockMvc mockmvc;
	@MockBean
	private BookingDetails bookingDetails;
	@MockBean
	private RestClientService service;

	@Test
	public void testTheatre() throws Exception {
		doNothing().when(bookingDetails).setMovieId(1);
		doNothing().when(bookingDetails).setMovieName("war");
		Theatre theatre1 = new Theatre();
		theatre1.setTheatreId(1);
		theatre1.setName("pvr cyberabad");

		Theatre theatre2 = new Theatre();
		theatre2.setTheatreId(2);
		theatre2.setName("Galleria Mall");

		Theatre theatre3 = new Theatre();
		theatre3.setTheatreId(3);
		theatre3.setName("BR Hitech Theatre");

		Theatre theatre4 = new Theatre();
		theatre4.setTheatreId(4);
		theatre4.setName("PVR Inorbit Mall");

		List<Theatre> theatreList = Arrays.asList(theatre1, theatre2, theatre3, theatre4);
		when(service.getAllTheatresForMovieSelected()).thenReturn(theatreList);
		mockmvc.perform(get("/theatre?movie=1%2Cwar")).andExpect(status().isOk())
				.andExpect(model().attribute("theatres", theatreList)).andExpect((forwardedUrl("theatre.jsp")));
	}

}
