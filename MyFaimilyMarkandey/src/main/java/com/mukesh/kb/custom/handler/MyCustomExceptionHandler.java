package com.mukesh.kb.custom.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mukesh.kb.exception.MyFamilyNotFoundException;

@RestControllerAdvice
public class MyCustomExceptionHandler {
	
	@ExceptionHandler(MyFamilyNotFoundException.class)
	public ResponseEntity<String> handleException(MyFamilyNotFoundException myException){
		return new ResponseEntity<String>(myException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
