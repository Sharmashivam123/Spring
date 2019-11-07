package com.epam.bms.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.bean.Movie;
import com.epam.bms.bean.SeatRange;
import com.epam.bms.bean.Theatre;
import com.epam.bms.dao.BookingDates;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.util.BookingDetails;

class ServicesTest {

	@InjectMocks
	private Services mock;

	@Mock
	private DBOperation dBOperation;

	@Mock
	private BookingDates dates;

	@Mock
	private BookingDetails bookingDetails;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAvailableCities() throws Exception {
		List<City> expectedCityList = new ArrayList<City>();
		City city = new City();
		city.setCityId(1);
		city.setCityName("Hyderabad");
		expectedCityList.add(city);
		Mockito.when(dBOperation.getCityList()).thenReturn(expectedCityList);
		List<City> actualCityList = mock.getAvailableCities();
		assertEquals(expectedCityList, actualCityList);
	}

	@Test
	public void testGetAreaPinInCity() {
		Area area1 = new Area();
		area1.setPin(500081);
		area1.setAreaName("Gachibowli");

		Area area2 = new Area();
		area2.setPin(500082);
		area2.setAreaName("Madhapur");

		Area area3 = new Area();
		area3.setPin(500083);
		area3.setAreaName("Raidurgam");

		Area area4 = new Area();
		area4.setPin(500084);
		area4.setAreaName("Kukatpally");

		Area area5 = new Area();
		area5.setPin(500085);
		area5.setAreaName("Ameerpet");

		List<Area> expectedAreaList = new ArrayList<>(Arrays.asList(area1, area2, area3, area4, area5));
		Mockito.when(dBOperation.getAreaListByCity(1)).thenReturn(expectedAreaList);
		List<Area> actualAreaList = mock.getAreaPinInCity();
		assertEquals(expectedAreaList, actualAreaList);
	}

	@Test
	public void testGetMoviesAtLocation() {
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
		Mockito.when(dBOperation.getMovieListByAreaPin(500085)).thenReturn(expectedMovieList);
		List<Movie> actualMovieList = mock.getMoviesAtLocation();
		assertEquals(expectedMovieList, actualMovieList);
	}

	@Test
	public void testGetTheatreListByMovie() {
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
		List<Theatre> actualTheatreList = mock.getTheatreListByMovie();
		assertEquals(expectedTheatreList, actualTheatreList);

	}

	@Test
	public void testGetAvailableDates() {
		Map<Integer, LocalDate> expectedDatesMap = new HashMap<>();
		expectedDatesMap.put(1, LocalDate.now());
		expectedDatesMap.put(2, LocalDate.now().plusDays(1));
		expectedDatesMap.put(3, LocalDate.now().plusDays(2));
		Mockito.when(dates.getDates()).thenReturn(expectedDatesMap);
		Map<Integer, LocalDate> actualDatesMap = mock.getAvailableDates();
		assertEquals(expectedDatesMap, actualDatesMap);
	}

	@Test
	public void testGetShowTiming() {
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
		Map<Integer, LocalTime> actualShowTime = mock.getShowTiming(2);
		assertEquals(expectedShowTime, actualShowTime);
	}

	@Test
	public void testGetPriceRange() {
		SeatRange seatType1 = new SeatRange();
		seatType1.setSeatId("A1");
		seatType1.setCost(100);
		seatType1.setTier("silver");

		SeatRange seatType2 = new SeatRange();
		seatType2.setSeatId("A2");
		seatType2.setCost(100);
		seatType2.setTier("silver");

		SeatRange seatType3 = new SeatRange();
		seatType3.setSeatId("A3");
		seatType3.setCost(100);
		seatType3.setTier("silver");

		SeatRange seatType4 = new SeatRange();
		seatType3.setSeatId("A4");
		seatType3.setCost(100);
		seatType3.setTier("silver");

		SeatRange seatType5 = new SeatRange();
		seatType3.setSeatId("A5");
		seatType3.setCost(100);
		seatType3.setTier("silver");

		SeatRange seatType6 = new SeatRange();
		seatType3.setSeatId("A6");
		seatType3.setCost(100);
		seatType3.setTier("silver");

		SeatRange seatType7 = new SeatRange();
		seatType3.setSeatId("A7");
		seatType3.setCost(100);
		seatType3.setTier("silver");

		SeatRange seatType8 = new SeatRange();
		seatType3.setSeatId("A8");
		seatType3.setCost(100);
		seatType3.setTier("silver");

		SeatRange seatType9 = new SeatRange();
		seatType3.setSeatId("A9");
		seatType3.setCost(100);
		seatType3.setTier("silver");

		SeatRange seatType10 = new SeatRange();
		seatType3.setSeatId("A10");
		seatType3.setCost(100);
		seatType3.setTier("silver");

		List<SeatRange> expectedSeatList = Arrays.asList(seatType1, seatType2, seatType3, seatType4, seatType5,
				seatType6, seatType7, seatType8, seatType9, seatType10);
		Mockito.when(dBOperation.getPriceRange("silver")).thenReturn(expectedSeatList);
		List<SeatRange> actualSeatList = mock.getPriceRanges("silver");
		assertEquals(expectedSeatList, actualSeatList);
	}

	@Test
	public void testProcessBooking() {
		Mockito.when(dBOperation.processBooking()).thenReturn(true);
		boolean bool = mock.processBooking();
		assertTrue(bool);
	}

	
	@Test
	public void testGetTotalCost() {
		PriceCalculation priceCalculation = Mockito.mock(PriceCalculation.class);
		Mockito.when(priceCalculation.calculatePrice()).thenReturn(385.333);
		double expectedCost = 385.333;
		double actualCost = mock.getTotalCost();
		assertEquals(expectedCost, actualCost);
	}

}
