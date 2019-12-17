package com.epam.services.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.bean.SeatArrangements;
import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.repo.BookingsDao;
import com.epam.repo.SeatArrangementsDao;
import com.epam.services.SeatsServices;
import com.epam.util.ApplicationConstants;

@Service
public class SeatsServicesImpl implements SeatsServices {
	@Autowired
	private BookingDetails bookingDetails;
	@Autowired
	private SeatArrangementsDao seatArrangementsDao;
	@Autowired
	BookingsDao bookingsDao;

	public Map<SeatArrangements, Boolean> getSeatRanges(String tier) {
		int movieId;
		int theatreId;
		LocalTime time;
		LocalDate date;
		String[] seatArray;
		movieId = bookingDetails.getMovieId();
		theatreId = bookingDetails.getTheatreId();
		time = bookingDetails.getTime();
		date = bookingDetails.getDate();
		List<String> bookedSeats = bookingsDao.findBookedSeats(movieId, theatreId, time, date);
		String seats = bookedSeats.toString();
		int len = seats.length();
		seats = seats.substring(1, len - 1);
		seats = seats.replace(",", "");
		seats = seats.replace("  ", " ");
		seats = seats.replace("  ", " "); 
		seatArray = seats.split(" ");
		List<SeatArrangements> seatList = seatArrangementsDao.findAllByTier(tier);
		List<SeatArrangements> unBookedSeatsList = new ArrayList<>();
		boolean check;
		for (SeatArrangements seat : seatList) {
			check = false;
			for (String strSeat : seatArray)
				if (seat.getSeatId().equals(strSeat))
					check = true;
			if (!check)
				unBookedSeatsList.add(seat);
		}
		Collections.sort(unBookedSeatsList, (o1, o2) -> o1.compareTo(o2));
		unBookedSeatsList = Optional.ofNullable(unBookedSeatsList).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));

		Map<SeatArrangements, Boolean> seatStatusMap = new TreeMap<>();
		for (SeatArrangements seat : seatList)
			seatStatusMap.put(seat, true);

		for (SeatArrangements seat : unBookedSeatsList)
			seatStatusMap.put(seat, false);
		return seatStatusMap;
	}
}
