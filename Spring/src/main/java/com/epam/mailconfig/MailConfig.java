package com.epam.mailconfig;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.epam.bean.BookingDetails;

@Configuration
@Aspect
public class MailConfig {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private BookingDetails bookingDetails;

	@Pointcut("execution(* com.epam.controller.TicketsDetailController.doGet())")
	public void book() { 

	}

	@After("book()")
	public void sendMail() {
		SimpleMailMessage email = new SimpleMailMessage();
		String header = "Congratulations Folk !!! your Fake ticket is booked. Here are the details:";
		String date = "date : " + bookingDetails.getDate();
		String bookingID = "Booking Id : " + bookingDetails.getBookingId();
		String movie = "Movie : " + bookingDetails.getMovieName();
		String theater = "Theater : " + bookingDetails.getTheatreId();
		String seats = "seat numbers : " + bookingDetails.getCostAndSeatId();
		String screen = "Screen : " + bookingDetails.getTime();
		String price = "price : " + bookingDetails.getTotalCost();
		String footer = "Send Money to Client please.....";
		String textbody = header + "\n\n" + bookingID + "\n" + date + "\n" + movie + "\n" + theater + "\n" + seats
				+ "\n" + screen + "\n" + price + "\n\n" + footer;
		email.setTo("shivamsharma.js@gmail.com");
		email.setFrom("shivamwayword@gmail.com");
		email.setSubject("Ticket Confirmation");
		email.setText(textbody);
		javaMailSender.send(email);
	}

}
