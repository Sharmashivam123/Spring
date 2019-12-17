package com.epam.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epam.bean.Bookings;
import com.epam.util.Constants;

public interface BookingsDao extends CrudRepository<Bookings, Integer>{

	@Query(nativeQuery = true, value= Constants.SELECTED_SEATID_QUERY)
	public List<String> findBookedSeats(int movieId, int theatreId,
			LocalTime time, LocalDate date);
} 
