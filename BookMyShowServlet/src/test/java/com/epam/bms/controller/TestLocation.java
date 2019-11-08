package com.epam.bms.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.bms.bean.Area;
import com.epam.bms.bean.City;
import com.epam.bms.controller.CityServlet;
import com.epam.bms.controller.LocationServlet;
import com.epam.bms.dao.DBOperation;
import com.epam.bms.services.Services;
import com.epam.bms.util.BookingDetails;

class TestLocation {

	
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
		Services services = Mockito.mock(Services.class);
		 RequestDispatcher rd=Mockito.mock(RequestDispatcher.class);
		 BookingDetails bookingDetails = Mockito.mock(BookingDetails.class);
		 Mockito.when(request.getParameter("city")).thenReturn("1");
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
			List<Area> actualAreaList = services.getAreaPinInCity();
			
		 Mockito.when(request.getRequestDispatcher("Location.jsp")).thenReturn(rd);
		 new LocationServlet().doGet(request, response);
		 bookingDetails.setCityId(1);
		 Mockito.verify(bookingDetails).setCityId(1);
		 request.setAttribute("areaList", expectedAreaList);
		 Mockito.verify(request).setAttribute("areaList", expectedAreaList);
		 Mockito.verify(rd).forward(request, response);
		
	}

}
