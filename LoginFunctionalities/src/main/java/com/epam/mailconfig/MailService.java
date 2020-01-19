package com.epam.mailconfig;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.epam.Entity.PasswordResetToken;

@Service
public class MailService {
	@Autowired
	JavaMailSender javaMailSender;

	public boolean sendMail(String mailId, HttpServletRequest request, PasswordResetToken token) {
		boolean check = false;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("shivamwayword@gmail.com");
		email.setTo(mailId);
		email.setSubject("PasswordResetLink");
		email.setText(getBody(request, token));
		javaMailSender.send(email);
		return check;
	}

	private String getBody(HttpServletRequest request, PasswordResetToken token) {
		String body = "Here's the link for your resetting the password.\n\n";
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ "/reset-password?token=" + token.getToken();
		body += url + "\n";
		body += "\nThanks and Regards";
		return body;
	}
}
