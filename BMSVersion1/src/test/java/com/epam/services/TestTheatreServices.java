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
import com.epam.bean.Theatre;
import com.epam.repo.TheatreDao;
import com.epam.services.impl.TheatreServicesImpl;

class TestTheatreServices {
	@InjectMocks
	TheatreServicesImpl mock;

	@Mock
	private TheatreDao theatreDao;
	@Mock
	private BookingDetails bookingDetails;

	@Test
	public void testTheatre() {
		MockitoAnnotations.initMocks(this);
		when(bookingDetails.getMovieId()).thenReturn(1);
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
		when(theatreDao.findAllByMovieId(1)).thenReturn(theatreList);
		assertEquals(theatreList, theatreDao.findAllByMovieId(1));
	}
}
