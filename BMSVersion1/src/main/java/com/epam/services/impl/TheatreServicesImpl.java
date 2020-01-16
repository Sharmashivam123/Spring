package com.epam.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.Theatre;
import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.repo.TheatreDao;
import com.epam.services.TheatreServices;
import com.epam.util.ApplicationConstants;

@Service
public class TheatreServicesImpl implements TheatreServices {
	@Autowired
	private TheatreDao theatreDao;

	public List<Theatre> getTheatreListByMovie(int movieId) {
		return Optional.ofNullable(theatreDao.findAllByMovieId(movieId)).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));

	}

	@Override
	public List<Theatre> getAllTheatre() {
		return (List<Theatre>) theatreDao.findAll();
	}

	@Override
	public void delete(int theatreId) {
		theatreDao.deleteById(theatreId);
	}

	@Override
	public void add(Theatre theatre) {
		theatreDao.save(theatre);
	}

	@Override
	public void update(int theatreId, String theatreName) {
		Theatre theatre = new Theatre();
		theatre.setTheatreId(theatreId);
		Optional<Theatre> optional = theatreDao.findById(theatre.getTheatreId());
		if (optional.isPresent()) {
			theatre.setName(theatreName);
			theatreDao.save(theatre);
		}

	}

}
