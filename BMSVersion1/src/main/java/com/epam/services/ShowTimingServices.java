package com.epam.services;

import java.time.LocalDate;
import java.util.List;

import com.epam.bean.ShowTimings;

public interface ShowTimingServices {
	public List<String> getShowTiming(int movieId, int theatreId, LocalDate date);

	public List<ShowTimings> getAllTimings();

	public ShowTimings update(ShowTimings timing);

	public void delete(int timingId);

	public ShowTimings add(ShowTimings timing);
}
