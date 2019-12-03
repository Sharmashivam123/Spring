package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.bean.BookingDetails;
import com.epam.bean.ShowTimings;
import com.epam.dao.ShowTimesDao;
import com.epam.services.servicesImpl.ShowTimingServicesImpl;

class TestShowServices {
	@InjectMocks
	ShowTimingServicesImpl mock;

	@Mock
	private ShowTimesDao showTimesDao;
	@Mock
	private BookingDetails bookingDetails;

	@Test
	void test() {
		MockitoAnnotations.initMocks(this);
		when(bookingDetails.getTheatreId()).thenReturn(1);
		when(bookingDetails.getMovieId()).thenReturn(1);
		ShowTimings availableShows = new ShowTimings();
		availableShows.setShow1(LocalTime.parse("10:00"));
		availableShows.setShow2(LocalTime.parse("13:00"));
		availableShows.setShow3(LocalTime.parse("18:00"));
		availableShows.setShow4(LocalTime.parse("22:15"));
		when(showTimesDao.findByMovieIdAndTheatreId(1, 1)).thenReturn(availableShows);
		assertEquals(availableShows, showTimesDao.findByMovieIdAndTheatreId(1, 1));
	}

}
