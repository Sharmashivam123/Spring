package com.epam.bms.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.bms.bean.Theatre;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

class TestTheatreServlet {
	@InjectMocks
	LocationServlet mock;

	@Mock
	DBOperation dBOperation;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testDoGet() throws Exception {

		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
		Services services = Mockito.mock(Services.class);
		Mockito.when(request.getParameter("movie")).thenReturn("1");
		BookingDetails bookingDetails = Mockito.mock(BookingDetails.class);
		bookingDetails.setMovieId((Integer.parseInt("1")));
		Mockito.verify(bookingDetails).setMovieId(Integer.parseInt("1"));
		Theatre theatre1 = new Theatre();
		theatre1.setTheatreId(1);
		;
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

		List<Theatre> expectedTheatreList = Arrays.asList(theatre1, theatre2, theatre3, theatre4);

		Mockito.when(dBOperation.getTheatreListByMovie(4)).thenReturn(expectedTheatreList);
		List<Theatre> actualTheatreList = services.getTheatreListByMovie();
		request.setAttribute("theatres", actualTheatreList);
		Mockito.verify(request).setAttribute("theatres", actualTheatreList);
		RequestDispatcher rd = Mockito.mock(RequestDispatcher.class);
		Mockito.when(request.getRequestDispatcher("Theatre.jsp")).thenReturn(rd);
		Mockito.when(request.getRequestDispatcher("/Error")).thenReturn(rd);
		new TheatreServlet().doGet(request, response);
		Mockito.verify(rd).forward(request, response);
	}

}
