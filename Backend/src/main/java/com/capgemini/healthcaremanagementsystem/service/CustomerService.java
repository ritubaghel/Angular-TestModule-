package com.capgemini.healthcaremanagementsystem.service;

import java.util.List;

import com.capgemini.healthcaremanagementsystem.entity.Appointment;
import com.capgemini.healthcaremanagementsystem.entity.Customer;
import com.capgemini.healthcaremanagementsystem.entity.Test;

public interface CustomerService {

	Test getTestById(Long id);

	Customer registerCustomer(Customer customer);

	Customer customerLogin(String customerName, String customerPassword);
	
	Appointment  makeAppointment(Appointment appointment,Long customerId,Long testId);
	
	Appointment getAppointmentById(Long appointmentId);
	
	List<Appointment> getAllAppointment();

}
