package com.citiustech.utility;

import java.time.LocalDateTime;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.citiustech.exception.ProjectManagementException;

@RestControllerAdvice
public class ExceptionControlerAdvice {


	@ExceptionHandler(ProjectManagementException.class)
	public ResponseEntity<ErrorInfo> ProjectManagementErrorHandler(ProjectManagementException exception){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> ExceptionHandler(Exception exception){
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
