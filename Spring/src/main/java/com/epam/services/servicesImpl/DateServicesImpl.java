package com.epam.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.BookingDatesDao;
import com.epam.services.DateServices;

@Service
public class DateServicesImpl implements DateServices{
	@Autowired
	private BookingDatesDao dates;
	
	public List<String> getAvailableDates() {
		List<String> dateMap = dates.getDates();
		return dateMap;
	}

}
