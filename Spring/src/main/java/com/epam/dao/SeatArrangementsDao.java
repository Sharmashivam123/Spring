package com.epam.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.bean.SeatArrangements;

public interface SeatArrangementsDao extends CrudRepository<SeatArrangements, Integer>{
	
	List<SeatArrangements> findAllByTier(String tier);

}
