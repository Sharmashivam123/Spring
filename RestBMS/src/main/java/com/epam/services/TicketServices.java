package com.epam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.TicketsDetails;
import com.epam.dao.TicketDetailsDao;

@Service
public class TicketServices {
	@Autowired
	private TicketsDetails ticketDetails;
	@Autowired
	private TicketDetailsDao ticketDetailsDao;

	public TicketsDetails getTicketDetails() {
		ticketDetails = ticketDetailsDao.getTicketDetails();
		return ticketDetails;
	}

}
