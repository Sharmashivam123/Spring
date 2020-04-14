package com.epam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.dto.UserRegisterationDto;
import com.epam.entity.User;
import com.epam.mapper.UserMapper;
import com.epam.service.UserService;

@RequestMapping("/register")
@Controller
public class RegisterationController {

	@Autowired
	UserService userService;

	@ModelAttribute("dto")
	public UserRegisterationDto getData() {
		return new UserRegisterationDto();
	}

	@GetMapping
	public String register() {
		return "register";
	}

	@PostMapping
	public ModelAndView registerUser(@ModelAttribute("dto") @Valid UserRegisterationDto userRegisterationDto,
			BindingResult result) {
		ModelAndView model = new ModelAndView();
		if (result.hasErrors())
			return new ModelAndView("register");
		User user = UserMapper.Instance.toUserFromUserRegisterationDto(userRegisterationDto);
		user = userService.saveUser(user);
		if (user == null) {

			model.addObject("status", 0);
			model.addObject("msg", "Registeration Failed");
			model.setViewName("register");
			return model;
		}
		model.addObject("status", 1);
		model.addObject("msg", "Registeration Success");
		model.setViewName("register");
		return model;
	}

}
