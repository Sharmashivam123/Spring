package com.epam.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.repo.BookingDatesDao;
import com.epam.services.impl.DateServicesImpl;

class TestDateServices {
	@InjectMocks
	DateServicesImpl mock;

	@Mock
	private BookingDatesDao dates;

	@Test
	public void testDate() {
		int index = 0;
		MockitoAnnotations.initMocks(this);
		List<String> dateList = new ArrayList<>();
		List<LocalDate> localDateList = new ArrayList<>();
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.now().plusDays(1);
		LocalDate date3 = LocalDate.now().plusDays(2);
		localDateList.addAll(Arrays.asList(date1, date2, date3));
		for (LocalDate date : localDateList) {
			dateList.add(index++, date.toString());
		}
		when(dates.getDates()).thenReturn(dateList);
		assertThat(dateList);
	}

}
