package com.epam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.BookingDetails;
import com.epam.bean.Theatre;
import com.epam.dao.TheatreDao;

@Service
public class TheatreServices {
	@Autowired
	private TheatreDao theatreDao;
	@Autowired
	private BookingDetails bookingDetails;

	public List<Theatre> getTheatreListByMovie() {
		int movieId = bookingDetails.getMovieId();
		List<Theatre> listTheatre = theatreDao.findAllByMovieId(movieId);
		return listTheatre;
	}
}
