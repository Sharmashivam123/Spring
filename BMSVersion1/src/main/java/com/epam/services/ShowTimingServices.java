package com.epam.services;

import java.time.LocalDate;
import java.util.List;

public interface ShowTimingServices {
	public List<String> getShowTiming(int movieId, int theatreId, LocalDate date);
}
