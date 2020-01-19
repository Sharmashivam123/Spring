package com.epam.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.Entity.PasswordResetToken;
import com.epam.Entity.User;
import com.epam.dto.ForgetPasswordDto;
import com.epam.mailconfig.MailService;
import com.epam.service.PasswordResetTokenService;
import com.epam.service.UserService;

@Controller
@RequestMapping("/forgot")
public class ForgetPasswordController {

	@Autowired
	UserService service;
	@Autowired
	PasswordResetTokenService tokenService;
	@Autowired
	MailService mailService;

	@ModelAttribute("forgot-password-dto")
	public ForgetPasswordDto dto() {
		return new ForgetPasswordDto();
	}

	@GetMapping
	public String forgotPasswordPage() {
		return "forgot-password";
	}

	@PostMapping
	public ModelAndView sendMail(@ModelAttribute ForgetPasswordDto dto, BindingResult result, HttpServletRequest request) {
		System.out.println(dto.getEmail());
		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			model.setViewName("forgot-password");
			model.addObject("errors", result);
			return model;
		}
		User user = service.findByUserName(dto);
		if (user == null) {
			result.rejectValue("username or email", "username or email is not correct.");
			model.addObject("errors", result);
			model.setViewName("forgot-password");
			return model;
		}
		PasswordResetToken token = new PasswordResetToken();
		token.setUser(user);
		token.setToken(UUID.randomUUID().toString());
		token.setExpiryDate(30);
		token = tokenService.saveToken(token);
		mailService.sendMail(user.getUsername(), request, token);
		model.addObject("mailStatus", "success");
		model.setViewName("forgot-password");
		return model;
	}
}
