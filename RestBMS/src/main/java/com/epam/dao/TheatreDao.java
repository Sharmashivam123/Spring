package com.epam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epam.bean.Theatre;
import com.epam.util.Constants;

public interface TheatreDao extends CrudRepository<Theatre, Integer> {

	@Query(nativeQuery = true, value = Constants.THEATRE_BY_MOVIE_QUERY)
	List<Theatre> findAllByMovieId(int movieId);

}
