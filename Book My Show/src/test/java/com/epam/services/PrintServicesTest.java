package com.epam.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.epam.bms.bean.SeatTypes;
import com.epam.bms.bean.Theatre;
import com.epam.bms.dao.BookingDates;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.services.PriceCalculation;
import com.epam.bms.services.PrintServices;
import com.epam.bms.util.BookingDetails;

public class PrintServicesTest {

	@InjectMocks
	private PrintServices mock;

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
	public void testShowAvailableCities() throws Exception {
		List<City> actualCityList = new ArrayList<City>();
		City city = new City();
		city.setCityId(1);
		city.setCityName("Hyderabad");
		actualCityList.add(city);
		Mockito.when(dBOperation.getCityList()).thenReturn(actualCityList);
		List<City> expectedCityList = dBOperation.getCityList();
		assertEquals(expectedCityList, actualCityList);
	}

	@Test
	public void testPrintAreaPinInCity() {
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
		Mockito.when(dBOperation.getAreaListByCity("1")).thenReturn(expectedAreaList);
		List<Area> actualAreaList = dBOperation.getAreaListByCity("1");
		assertEquals(expectedAreaList, actualAreaList);
	}

	@Test
	public void testPrintMoviesAtLocation() {
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
		Mockito.when(dBOperation.getMovieListByAreaPin("500085")).thenReturn(expectedMovieList);
		List<Movie> actualMovieList = dBOperation.getMovieListByAreaPin("500085");
		assertEquals(expectedMovieList, actualMovieList);
	}

	@Test
	public void testPrintTheatreListByMovie() {
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
		List<Theatre> actualTheatreList = dBOperation.getTheatreListByMovie(4);
		assertEquals(expectedTheatreList, actualTheatreList);

	}

	@Test
	public void testPrintAvailableDates() {
		Map<Integer, LocalDate> expectedDatesMap = new HashMap<>();
		expectedDatesMap.put(1, LocalDate.now());
		expectedDatesMap.put(2, LocalDate.now().plusDays(1));
		expectedDatesMap.put(3, LocalDate.now().plusDays(2));
		Mockito.when(dates.getDates()).thenReturn(expectedDatesMap);
		Map<Integer, LocalDate> actualDatesMap = dates.getDates();
		assertEquals(expectedDatesMap, actualDatesMap);
	}

	@Test
	public void testPrintShowTiming() {
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
		Map<Integer, LocalTime> actualShowTime = dBOperation.getShowtimings(2);
		assertEquals(expectedShowTime, actualShowTime);
	}

	@Test
	public void testPriceRange() {
		SeatTypes seatType1 = new SeatTypes();
		seatType1.setRangeId(1);
		seatType1.setCost(100);
		seatType1.setTier("silver");

		SeatTypes seatType2 = new SeatTypes();
		seatType2.setRangeId(2);
		seatType2.setCost(150);
		seatType2.setTier("gold");

		SeatTypes seatType3 = new SeatTypes();
		seatType3.setRangeId(3);
		seatType3.setCost(200);
		seatType3.setTier("platinum");

		List<SeatTypes> expectedSeatList = Arrays.asList(seatType1, seatType2, seatType3);
		Mockito.when(dBOperation.getPriceRange()).thenReturn(expectedSeatList);
		List<SeatTypes> actualSeatList = dBOperation.getPriceRange();
		assertEquals(expectedSeatList, actualSeatList);
	}
	
	@Test
	public void testPriceCalculation() 
	{
		double expectedCost = 150.00;
		Mockito.when(dBOperation.getCost(2)).thenReturn(expectedCost);
		double actualCost = dBOperation.getCost(2);
		PriceCalculation priceCalculation = null;
		double expectedTotalCost = 750.00;
		Mockito.when(priceCalculation.calculatePrice(150, 5)).thenReturn(expectedTotalCost);
		double actualTotalCost = priceCalculation.calculatePrice(150, 5);
		assertEquals(expectedCost, actualCost);
		assertEquals(expectedTotalCost, actualTotalCost);	
	}

}
