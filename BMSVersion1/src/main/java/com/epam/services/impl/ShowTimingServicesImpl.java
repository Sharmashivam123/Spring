package com.epam.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.ShowTimings;
import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.repo.ShowTimesDao;
import com.epam.services.ShowTimingServices;
import com.epam.util.ApplicationConstants;

@Service
public class ShowTimingServicesImpl implements ShowTimingServices {
	@Autowired
	private ShowTimesDao showTimesDao;

	public List<String> getShowTiming(int movieId, int theatreId, LocalDate date) {
		List<LocalTime> timeList;
		List<String> timeIndexList;
		ShowTimings availableShows = showTimesDao.findByMovieIdAndTheatreId(theatreId, movieId);
		LocalTime show1 = availableShows.getShow1();
		LocalTime show2 = availableShows.getShow2();
		LocalTime show3 = availableShows.getShow3();
		LocalTime show4 = availableShows.getShow4();
		timeList = new ArrayList<>();
		timeList.addAll(Arrays.asList(show1, show2, show3, show4));
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

		return Optional.ofNullable(timeIndexList).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));
	}

	@Override
	public List<ShowTimings> getAllTimings() {
		return (List<ShowTimings>) showTimesDao.findAll();
	}

	@Override
	public ShowTimings update(ShowTimings timing) {
		Optional<ShowTimings> optional = showTimesDao.findById(timing.getTimingId());
		if (optional.isPresent()) {
			timing = showTimesDao.save(timing);
		}
		return timing;
	}

	@Override
	public void delete(int timingId) {
		showTimesDao.deleteById(timingId);
	}

	@Override
	public ShowTimings add(ShowTimings timing) {
		return showTimesDao.save(timing);
	}
}
