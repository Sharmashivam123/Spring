package com.epam.services.servicesImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ExceptionHandler.Exception.ServiceLayerException;
import com.epam.bean.BookingDetails;
import com.epam.bean.SeatArrangements;
import com.epam.dao.BookingsDao;
import com.epam.dao.SeatArrangementsDao;
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
	private int movieId, theatreId;
	private LocalTime time;
	private LocalDate date;
	private String[] seatArray;

	public Map<SeatArrangements, Boolean> getSeatRanges(String tier) {
		movieId = bookingDetails.getMovieId();
		theatreId = bookingDetails.getTheatreId();
		time = bookingDetails.getTime();
		date = bookingDetails.getDate();
		List<String> bookedSeats = bookingsDao.findBookedSeats(movieId, theatreId, time, date);
		String seats = bookedSeats.toString();
		int len = seats.length();
		seats = seats.substring(1, len - 1);
		seats = seats.replaceAll(",", "");
		seats = seats.replaceAll("  ", " ");
		seats = seats.replaceAll("  ", " ");
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
		Collections.sort(unBookedSeatsList, new Comparator<SeatArrangements>() {

			@Override
			public int compare(SeatArrangements o1, SeatArrangements o2) {
				return o1.getSeatId().compareTo(o2.getSeatId());
			}
		});
		Optional<List<SeatArrangements>> optionalMap = Optional.of(unBookedSeatsList);
		unBookedSeatsList = optionalMap.get();
		Optional.ofNullable(unBookedSeatsList).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));

		Map<SeatArrangements, Boolean> seatStatusMap = new TreeMap<>();
		for (SeatArrangements seat : seatList)
			seatStatusMap.put(seat, true);

		for (SeatArrangements seat : unBookedSeatsList)
			seatStatusMap.put(seat, false);
		return seatStatusMap;
	}
}
