package com.epam.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class BookingDatesDao {
	public List<String> getDates() {
		Integer index = 0;
		List<String> dateList = new ArrayList<>();
		List<LocalDate> localDateList = new ArrayList<>();
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.now().plusDays(1);
		LocalDate date3 = LocalDate.now().plusDays(2);
		localDateList.addAll(Arrays.asList(date1, date2, date3));
		for (LocalDate date : localDateList) {
			dateList.add(index++, date.toString());
		}
		Optional<List<String>> optionalMap = Optional.of(dateList);
		dateList = optionalMap.get();
		return dateList;
	}
}
