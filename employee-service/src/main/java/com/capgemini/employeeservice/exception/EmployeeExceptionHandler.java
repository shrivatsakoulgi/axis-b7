package com.capgemini.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<Object> employeeNotFoundExceptionHandler(EmployeeNotFoundException ex){
		return new ResponseEntity<Object>("Employee Not Found...",HttpStatus.NOT_FOUND);
	}

}
