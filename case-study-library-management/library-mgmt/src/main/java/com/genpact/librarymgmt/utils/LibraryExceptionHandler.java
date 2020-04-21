package com.genpact.librarymgmt.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.genpact.librarymgmt.model.AppMessage;
import com.genpact.librarymgmt.model.CustomException;

@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ CustomException.class })
	public ResponseEntity<Object> handleAppException(Exception ex, WebRequest request) {
		AppMessage error = new AppMessage(ex.getMessage());
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}
}
