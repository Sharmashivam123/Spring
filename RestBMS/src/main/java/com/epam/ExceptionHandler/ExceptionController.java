package com.epam.ExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	public static String message;

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleAnyException(Exception exception, WebRequest request) {
		return handleExceptionInternal(exception, message, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}
