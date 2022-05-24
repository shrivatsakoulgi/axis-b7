package com.capgemini.insuranceservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//Global Exception Handler class
@ControllerAdvice
public class InsuranceExceptionHandler {

	@ExceptionHandler(value=InsuranceNotFoundException.class)
	public ResponseEntity<Object> insuranceNotFoundExceptionHandler(InsuranceNotFoundException ex){
		return new ResponseEntity<Object>("Insurance Not found...",HttpStatus.NOT_FOUND);
				
	}
	
	@ExceptionHandler(value=DuplicateInsuranceException.class)
	public ResponseEntity<Object> duplicateExceptionHandler
	(DuplicateInsuranceException ex){
		return new ResponseEntity<Object>
		 ("Duplicate Insurance Inserted...",HttpStatus.BAD_REQUEST);
				
	}
}
