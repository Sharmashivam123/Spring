package com.epam.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.repo.BookingDatesDao;
import com.epam.services.DateServices;

@Service
public class DateServicesImpl implements DateServices {
	@Autowired
	private BookingDatesDao dates;

	public List<String> getAvailableDates() {
		return dates.getDates();
	}

}
