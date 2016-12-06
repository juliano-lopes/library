package com.jlopes.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jlopes.library.exception.BookNotFoundException;

@ControllerAdvice
@RestController
public class ExceptionController {
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BookNotFoundException.class)
	public String handleBookNotFoundException(BookNotFoundException exception) {
		return exception.getMessage();
	}
}
