package com.capgemini.healthcaremanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaremanagementsystem.exception.AdminNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.AppointmentAlreadyApprovedException;
import com.capgemini.healthcaremanagementsystem.exception.AppointmentNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.CenterAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CenterNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.ContactNumberAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CustomerNameAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CustomerNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.CenterDoesNotExistsException;
import com.capgemini.healthcaremanagementsystem.exception.EmailAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdDoesNotExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;

@RestController
@ControllerAdvice // used to handle all the exceptions across the application in one global
					// handling component.
public class GlobalErrorHandler {
	/**
	 * Name :handleAdminNotFoundException Description:To handle Admin with valid
	 * credentials not found
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Admin with valid credentials not found")
	@ExceptionHandler(AdminNotFoundException.class)
	public void handleAdminNotFoundException() {
		// TO handle Admin not found
	}
		
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Diagnostic Center not found")
	@ExceptionHandler(CenterDoesNotExistsException.class)
	public void handleDiagnosticCenterNotExistsException() {
		// TO handle Diagnostic Center not found
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Test not found")
	@ExceptionHandler(TestNotFoundException.class)
	public void handleTestNotFoundException() {
		//TO handle Test not found
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "TestId does not exists")
	@ExceptionHandler(TestIdDoesNotExistException.class)
	public void handleTestIdDoesNotExistException() {
		//TO handle TestId does not exists
	}
	
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Customer name already exist")
	@ExceptionHandler(CustomerNameAlreadyExistException.class)
	public void handleCustomerNameAlreadyExistException()
	{
	//TO handle CustomerDao name already exist
	}

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Contact number already exist")
	@ExceptionHandler(ContactNumberAlreadyExistException.class)
	public void handleContactNumberAlreadyExistException()
	{
	//TO handle Contact number already exist
	}

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Email already exist")
	@ExceptionHandler(EmailAlreadyExistException.class)
	public void handleEmailAlreadyExistException()
	{
	//TO handle Email already exist
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Customer not found")
	@ExceptionHandler(CustomerNotFoundException.class)
	public void handleCustomerNotFoundException()
	{
	//TO handle CustomerDao not found
	}
	
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Appointment already approved ")
	@ExceptionHandler(AppointmentAlreadyApprovedException.class)
	public void handleAppointmentAlreadyApprovedException()
	{
	//TO handle CustomerDao not found
	}
	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Appointment not found")
	@ExceptionHandler(AppointmentNotFoundException.class)
	public void handleAppointmentNotFoundException()
	{
		//TO handle AppointmentDao not found
	}	
	
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Center already exists")
	@ExceptionHandler(CenterAlreadyExistException.class)
	public void handleCenterAlreadyExistException()
	{
		//TO handle Diagnostic Center already exists
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Center not found")
	@ExceptionHandler(CenterNotFoundException.class)
	public void handleCenterNotFoundException()
	{
		//TO handle Diagnostic Center not found
	}
	
	
}
