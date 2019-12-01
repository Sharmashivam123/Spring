package com.epam.services.servicesImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.bean.ShowTimings;
import com.epam.dao.ShowTimesDao;
import com.epam.services.ShowTimingServices;

@Service
public class ShowTimingServicesImpl implements ShowTimingServices{
	@Autowired
	private ShowTimesDao showTimesDao;
	@Autowired
	private BookingDetails bookingDetails;
	private List<LocalTime> timeList;
	private List<String> timeIndexList;

	public List<String> getShowTiming() {
		int theatreId = bookingDetails.getTheatreId();
		int movieId = bookingDetails.getMovieId();
		LocalDate date = bookingDetails.getDate();
		ShowTimings availableShows = showTimesDao.findByMovieIdAndTheatreId(theatreId, movieId);
		LocalTime show1 = availableShows.getShow1();
		LocalTime show2 = availableShows.getShow2();
		LocalTime show3 = availableShows.getShow3();
		LocalTime show4 = availableShows.getShow4();
		timeList = new ArrayList<>();
		timeList.addAll(Arrays.asList(show1, show2, show3, show4));
		System.out.println(timeList);
		LocalDate currDate = LocalDate.now();
		int index = 0;
		timeIndexList = new ArrayList<>();

		for (LocalTime time : timeList) {
			if (date.compareTo(currDate) == 0) {
				if (time.compareTo(LocalTime.now().plusMinutes(15)) > 0)
					timeIndexList.add(index++, time.toString());
			} else
				timeIndexList.add(index++, time.toString());
		}
		System.out.println(timeIndexList);
		return timeIndexList;
	}
}
