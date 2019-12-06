package com.epam.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ExceptionHandler.Exception.ServiceLayerException;
import com.epam.bean.BookingDetails;
import com.epam.bean.Theatre;
import com.epam.dao.TheatreDao;
import com.epam.services.TheatreServices;
import com.epam.util.ApplicationConstants;

@Service
public class TheatreServicesImpl implements TheatreServices {
	@Autowired
	private TheatreDao theatreDao;
	@Autowired
	private BookingDetails bookingDetails;

	public List<Theatre> getTheatreListByMovie() {
		int movieId = bookingDetails.getMovieId();
		List<Theatre> listTheatre = theatreDao.findAllByMovieId(movieId);
		Optional.ofNullable(listTheatre).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));
		return listTheatre;
	}
}
