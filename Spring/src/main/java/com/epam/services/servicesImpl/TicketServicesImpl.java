package com.epam.services.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ExceptionHandler.Exception.ServiceLayerException;
import com.epam.bean.TicketsDetails;
import com.epam.dao.TicketDetailsDao;
import com.epam.services.TicketServices;
import com.epam.util.ApplicationConstants;

@Service
public class TicketServicesImpl implements TicketServices {
	@Autowired
	private TicketsDetails ticketDetails;
	@Autowired
	private TicketDetailsDao ticketDetailsDao;

	public TicketsDetails getTicketDetails() {
		ticketDetails = ticketDetailsDao.getTicketDetails();
		Optional.ofNullable(ticketDetails).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));

		return ticketDetails;
	}

}
