package com.epam.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.TicketsDetails;
import com.epam.exceptions.handlers.ServiceLayerException;
import com.epam.repo.TicketDetailsDao;
import com.epam.services.TicketServices;
import com.epam.util.ApplicationConstants;

@Service
public class TicketServicesImpl implements TicketServices {
	@Autowired
	private TicketDetailsDao ticketDetailsDao;

	public TicketsDetails getTicketDetails() {
		return Optional.ofNullable(ticketDetailsDao.getTicketDetails()).orElseThrow(
				() -> new ServiceLayerException(ApplicationConstants.SELECTED_ELEMENT_NOT_FOUND.toString()));
	}

}
