package com.epam.bms.bean;

import java.time.LocalTime;
import java.util.Map;

public class ShowTimes {
	private static ShowTimes instance = null;
	private Map<Integer, LocalTime> mapOfIndexTiming;

	private ShowTimes()
	{
		
	}
	
	public static ShowTimes getInstatnce() {
		if (instance == null)
			instance = new ShowTimes();
		return instance;
	}

	public Map<Integer, LocalTime> getAvailableShow() {
		return mapOfIndexTiming;
	}

	public void setAvailableShow(Map<Integer, LocalTime> mapOfIndexTiming) {
		this.mapOfIndexTiming = mapOfIndexTiming;
	}

}
