package com.epam.services;

import java.util.List;

import com.epam.bean.SeatArrangements;

public interface SeatsServices {
	public List<SeatArrangements> getSeatRanges(String tier);
}
