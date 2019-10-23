package com.epam.bms.util;

import java.time.LocalTime;
import java.util.Map;

public class Timings {
	private static Timings instance = null;
	private Map<Integer, LocalTime> mapOfIndexTiming;

	public static Timings getInstatnce() {
		if (instance == null)
			instance = new Timings();
		return instance;
	}

	public Map<Integer, LocalTime> getMapOfIndexTiming() {
		return mapOfIndexTiming;
	}

	public void setMapOfIndexTiming(Map<Integer, LocalTime> mapOfIndexTiming) {
		this.mapOfIndexTiming = mapOfIndexTiming;
	}

}
