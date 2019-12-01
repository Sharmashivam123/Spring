package com.epam.services.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bean.TicketsDetails;
import com.epam.dao.TicketDetailsDao;
import com.epam.services.TicketServices;

@Service
public class TicketServicesImpl implements TicketServices{
	@Autowired
	private TicketsDetails ticketDetails;
	@Autowired
	private TicketDetailsDao ticketDetailsDao;

	public TicketsDetails getTicketDetails() {
		ticketDetails = ticketDetailsDao.getTicketDetails();
		return ticketDetails;
	}

}
