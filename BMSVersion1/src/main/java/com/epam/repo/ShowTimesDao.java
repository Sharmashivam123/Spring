package com.epam.repo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epam.bean.ShowTimings;
import com.epam.util.Constants;

public interface ShowTimesDao extends CrudRepository<ShowTimings, Integer> {

	@Query(nativeQuery = true, value = Constants.SHOW_TIMING_OF_MOVIE_QUERY)
	ShowTimings findByMovieIdAndTheatreId(int theatreId, int movieId);

}
