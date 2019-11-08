package com.epam.bms.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.bms.dao.BookingDates;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

class TestDateServlet {


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
		 Mockito.when(request.getParameter("theatre")).thenReturn("1");
		 BookingDetails bookingDetails = Mockito.mock(BookingDetails.class);
		 bookingDetails.setTheatreId((Integer.parseInt("1")));
		Mockito.verify(bookingDetails).setTheatreId((Integer.parseInt("1")));
		 Services services = Mockito.mock(Services.class);
		 Map<Integer, LocalDate> expectedDatesMap = new HashMap<>();
			expectedDatesMap.put(1, LocalDate.now());
			expectedDatesMap.put(2, LocalDate.now().plusDays(1));
			expectedDatesMap.put(3, LocalDate.now().plusDays(2));
			BookingDates dates = Mockito.mock(BookingDates.class);
			Mockito.when(dates.getDates()).thenReturn(expectedDatesMap);
			Map<Integer, LocalDate> actualDatesMap = services.getAvailableDates();
			request.setAttribute("dates", actualDatesMap);
			Mockito.verify(request).setAttribute("dates", actualDatesMap);;
			 RequestDispatcher rd=Mockito.mock(RequestDispatcher.class);
			 Mockito.when(request.getRequestDispatcher("Date.jsp")).thenReturn(rd);
			 new DateServlet().doGet(request, response);
			 Mockito.verify(rd).forward(request, response);
	}

}
