package com.epam.bms.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingDates {
	public Map<Integer, LocalDate> getDates() {
		Integer index = 0;
		Map<Integer, LocalDate> map = new HashMap<>();
		List<LocalDate> dateList = new ArrayList<>();
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.now().plusDays(1);
		LocalDate date3 = LocalDate.now().plusDays(2);
		dateList.addAll(Arrays.asList(date1, date2, date3));
		for (LocalDate date : dateList) {
			map.put(++index, date);
		}
		return map;
	}
}
