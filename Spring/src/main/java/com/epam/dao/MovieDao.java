package com.epam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epam.bean.Movie;
import com.epam.util.Constants;

public interface MovieDao  extends CrudRepository<Movie, Integer> {
	@Query(nativeQuery = true, value = Constants.MOVIE_BY_LOCATION_QUERY)
	List<Movie> findAllByLocationId(int locationId);
}
