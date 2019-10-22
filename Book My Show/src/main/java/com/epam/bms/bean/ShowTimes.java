package com.epam.bms.bean;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class ShowTimes {
	private Map<Integer, Time> availableShow = new HashMap<>();

	public Map<Integer, Time> getAvailableShow() {
		return availableShow;
	}

	public void setAvailableShow(Map<Integer, Time> availableShow) {
		this.availableShow = availableShow;
	}
}
