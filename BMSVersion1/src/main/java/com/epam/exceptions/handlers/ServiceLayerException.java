package com.epam.exceptions.handlers;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.exceptions.ExceptionController;

public class ServiceLayerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ExceptionController exceptionController;

	@SuppressWarnings("static-access")
	public ServiceLayerException(String message) {
		exceptionController.message = message;
	}

}
