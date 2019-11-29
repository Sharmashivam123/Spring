package com.epam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dao.BookingDatesDao;

@Service
public class DateServices {
	@Autowired
	private BookingDatesDao dates;
	
	public List<String> getAvailableDates() {
		List<String> dateMap = dates.getDates();
		return dateMap;
	}

}
