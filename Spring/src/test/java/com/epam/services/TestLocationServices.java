package com.epam.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.epam.bean.BookingDetails;
import com.epam.bean.Location;
import com.epam.repo.LocationDao;
import com.epam.services.impl.LocationServicesImpl;

class TestLocationServices {

	@InjectMocks
	LocationServicesImpl mock;

	@Mock
	private LocationDao areaDao;
	@Mock
	private BookingDetails bookingDetails;
	@Mock
	private Location area1, area2, area3, area4, area5;

	@Test
	public void testCity() {
		MockitoAnnotations.initMocks(this);
		when(bookingDetails.getCityId()).thenReturn(1);
		area1.setPin(500081);
		area1.setAreaName("Gachibowli");

		area2.setPin(500082);
		area2.setAreaName("Madhapur");

		area3.setPin(500083);
		area3.setAreaName("Raidurgam");

		area4.setPin(500084);
		area4.setAreaName("Kukatpally");

		area5.setPin(500085);
		area5.setAreaName("Ameerpet");
		List<Location> areaList = new ArrayList<>(Arrays.asList(area1, area2, area3, area4, area5));
		when(areaDao.findAllByCityId(1)).thenReturn(areaList);
		assertEquals(areaList, areaDao.findAllByCityId(1));
	}

}
