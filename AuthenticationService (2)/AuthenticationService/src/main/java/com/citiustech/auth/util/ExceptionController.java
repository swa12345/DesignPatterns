package com.citiustech.auth.util;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.citiustech.auth.exception.UserException;
import com.citiustech.auth.exception.UserNotFoundException;
import com.citiustech.auth.exception.UsersNotFoundException;

@RestControllerAdvice
public class ExceptionController {

	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorInfo> userExceptionHandler(UserException exception){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage("User with email id already exists");
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.CONFLICT.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UsersNotFoundException.class)
	public ResponseEntity<ErrorInfo> usersNotFoundexceptionHandler(UsersNotFoundException exception){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage("There are currently no registered Users");
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorInfo> userNotFoundExceptionController(UserNotFoundException exception){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage("User with this User Id does not exists");
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
}
