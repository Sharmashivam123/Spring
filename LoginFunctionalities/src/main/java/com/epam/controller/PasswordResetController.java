package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.ResetPasswordDto;
import com.epam.entity.PasswordResetToken;
import com.epam.service.PasswordResetTokenService;

@RequestMapping("/reset")
@Controller
public class PasswordResetController {

	@Autowired
	PasswordResetTokenService service;

	@ModelAttribute("dto")
	public ResetPasswordDto sendModel()
	{
		return new ResetPasswordDto();
	}
	
	@GetMapping
	public ModelAndView getRequest(@RequestParam(required = false) String token) {
		ModelAndView model = new ModelAndView();
		PasswordResetToken resetToken = service.findByToken(token);
		if (resetToken == null) {
			model.addObject("error", "token not registered");
		} else if (resetToken.isExpired()) {
			model.addObject("error", "Token expired");
		}
		model.addObject("token", resetToken);
		return model;
	}

}
