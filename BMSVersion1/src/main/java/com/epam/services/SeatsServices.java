package com.epam.services;

import java.util.List;
import java.util.Map;

import com.epam.bean.SeatArrangements;

public interface SeatsServices {
	public Map<SeatArrangements, Boolean> getSeatRanges(String tier);

	public List<SeatArrangements> getSeatData();

	public SeatArrangements update(SeatArrangements seatarrangements);

	public void delete(String seatId);

	public void insert(SeatArrangements seatarrangements);
}
