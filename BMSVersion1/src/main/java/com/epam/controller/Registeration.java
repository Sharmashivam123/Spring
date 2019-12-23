package com.epam.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.bean.Credentials;
import com.epam.mailconfig.MailService;
import com.epam.securityconfig.MyUserDetails;
import com.epam.services.RestClientService;
import com.epam.util.Constants;

@Controller
public class Registeration {
	@Autowired
	RestClientService service;
	@Autowired
	Credentials credential;
	@Autowired
	MailService mailService;
	private int s = 0;

	@GetMapping("/register")
	public String register1() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			s = 0;
			if (principal instanceof MyUserDetails)
				return "index";
			else
				throw new Exception();

		} catch (Exception e) { 
			return "register";
		}
	}

	@GetMapping("/userregister")
	public ModelAndView register(@RequestParam(required = false) String user,
			@RequestParam(required = false) String pwd, @RequestParam(required = false) String phone) {
		ModelAndView model = new ModelAndView();
		try {
			s++;
			if (s > 1)
				throw new Exception();
			Credentials cred = new Credentials();
			cred.setPhone(phone);
			cred.setUser(user);
			cred.setPwd(pwd);
			Random random = new Random();
			int rand = random.nextInt(100000) + 999999;
			cred.setStatus(0);
			cred.setRole("USER");
			cred.setMyhash(String.valueOf(rand));
			cred = service.registerUser(cred);
			if (cred == null) {
				model.addObject("msg", "username present");
				model.addObject("status", 0);
			} else {
				model.addObject("msg", "Registeration Successful waiting for confirmation");
				model.addObject("status", 1);
				mailService.sendVerificationMail(cred.getUser(), cred.getMyhash());
			}
			model.setViewName("confirmation");
		} catch (Exception e) {
			model.setViewName("login");
			if (s > 1)
				model.setViewName("register");
		}
		return model;
	}

	@GetMapping("/confirm")
	public ModelAndView confirm() {
		String username = "";
		String role = "";
		int status = 0;
		ModelAndView model = new ModelAndView();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {

			if (principal instanceof MyUserDetails)
				username = ((MyUserDetails) principal).getUsername();
			else
				throw new Exception();

			credential = service.getUserData(username);
			status = credential.getStatus();
			role = credential.getRole();
			if (status == 1) {
				if (role.equals("USER"))
					model.setViewName(Constants.INDEX);
				else
					model.setViewName("home");
				model.addObject("status", status);

			} else
				throw new Exception();

		} catch (Exception e) {
			if (status == 0)
				model.setViewName("verify");
			else
				model.setViewName("login");

		}
		return model;
	}

	@GetMapping("/verify")
	public ModelAndView verify(@RequestParam(required = false) String otp) {
		String username = "";
		ModelAndView model = new ModelAndView();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			if (principal instanceof MyUserDetails)
				username = ((MyUserDetails) principal).getUsername();
			else
				throw new Exception();
			credential = service.getUserData(username);
			if (credential.getStatus() == 1)
				throw new Exception();
			if (!credential.getMyhash().equals(otp)) {
				model.addObject("error", "Enter the right otp");
				model.setViewName("verify");
				confirm();
			} else {

				credential.setStatus(1);
				credential = service.update(credential);
				model.addObject("status", credential.getStatus());
				model.setViewName(Constants.INDEX);
			}
		} catch (Exception e) {
			model.setViewName("login");
			if (credential.getStatus() == 1)
				model.setViewName(Constants.INDEX);
		}

		return model;
	}

}
