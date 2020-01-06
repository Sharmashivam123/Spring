package com.epam.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.epam.bean.SeatArrangements;

public interface SeatArrangementsDao extends CrudRepository<SeatArrangements, String> {

	List<SeatArrangements> findAllByTier(String tier);

	Optional<SeatArrangements> findBySeatId(String seatId);

	void deleteBySeatId(String seatId);

}
