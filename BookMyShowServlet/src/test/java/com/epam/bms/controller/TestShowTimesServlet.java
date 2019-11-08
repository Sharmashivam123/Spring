package com.epam.bms.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

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

import com.epam.bms.dao.BookingDates;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

class TestShowTimesServlet {
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
		Mockito.when(request.getParameter("date")).thenReturn("2");
		BookingDetails bookingDetails = Mockito.mock(BookingDetails.class);
		bookingDetails.setDateId((Integer.parseInt("2")));
		Mockito.verify(bookingDetails).setDateId(Integer.parseInt("2"));
		Map<Integer, LocalDate> expectedDatesMap = new HashMap<>();
		expectedDatesMap.put(1, LocalDate.now());
		expectedDatesMap.put(2, LocalDate.now().plusDays(1));
		expectedDatesMap.put(3, LocalDate.now().plusDays(2));
		BookingDates dates = Mockito.mock(BookingDates.class);
		Mockito.when(dates.getDates()).thenReturn(expectedDatesMap);
		Map<Integer, LocalDate> actualDatesMap = services.getAvailableDates();
		
		Map<Integer, LocalTime> expectedShowTime = new HashMap<>();
		LocalTime time1 = LocalTime.parse("12:00");
		expectedShowTime.put(1, time1);
		LocalTime time2 = LocalTime.parse("15:00");
		expectedShowTime.put(2, time2);
		LocalTime time3 = LocalTime.parse("18:00");
		expectedShowTime.put(3, time3);
		LocalTime time4 = LocalTime.parse("22:15");
		expectedShowTime.put(4, time4);

		Mockito.when(dBOperation.getShowtimings(2)).thenReturn(expectedShowTime);
		Map<Integer, LocalTime> actualShowTime = services.getShowTiming(2);
		
		request.setAttribute("shows", actualShowTime);
		Mockito.verify(request).setAttribute("shows", actualShowTime);
		 RequestDispatcher rd=Mockito.mock(RequestDispatcher.class);
		 Mockito.when(request.getRequestDispatcher("Shows.jsp")).thenReturn(rd);
		 new ShowTimesServlet().doGet(request, response);
		 Mockito.verify(rd).forward(request, response);
	}

}
