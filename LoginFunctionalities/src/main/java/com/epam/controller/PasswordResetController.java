package com.epam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.ResetPasswordDto;
import com.epam.entity.PasswordResetToken;
import com.epam.entity.User;
import com.epam.service.PasswordResetTokenService;
import com.epam.service.UserService;

@RequestMapping("/reset")
@Controller
public class PasswordResetController {

	@Autowired
	PasswordResetTokenService service;
	@Autowired
	UserService userService;

	@ModelAttribute("dto")
	public ResetPasswordDto sendModel() {
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
		model.setViewName("reset");
		return model;
	}

	@PostMapping
	public ModelAndView changePassword(@ModelAttribute("dto") @Valid ResetPasswordDto dto, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			return new ModelAndView("reset");
		}
		PasswordResetToken token = service.findByToken(dto.getToken());
		User user = token.getUser();
		if (user == null) {
			model.addObject("error", "user request failed");
		} else {
			userService.updatePassword(user, dto.getPassword());
			model.addObject("error", "user password changed successfully");
		}
		model.setViewName("reset");
		return model;
	}

}
