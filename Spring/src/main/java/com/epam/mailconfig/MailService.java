package com.epam.mailconfig;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.epam.bean.Credentials;

@Service
public class MailService {
	private static final Logger log = Logger.getLogger(MailConfig.class);
	@Autowired
	Credentials cred;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendVerificationMail() {
		log.info("inside mail");
		try {
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(cred.getUser());
			email.setFrom("shivamwayword@gmail.com");
			email.setSubject("Confirmation Mail");
			email.setText(getConfirmationMailBody());
			javaMailSender.send(email);
		} catch (Exception e) {
			return;
		}
	}

	public String getConfirmationMailBody() {
		String header = "Please carry the otp for activating your account\n\n";
		String activationLink = "your OTP is :: " + cred.getMyhash();
		return header + "\n\n" + activationLink;
	}
}
