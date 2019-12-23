package com.epam.services;

import java.util.Map;

import com.epam.bean.SeatArrangements;

public interface SeatsServices {
	public Map<SeatArrangements, Boolean> getSeatRanges(String tier);
}
