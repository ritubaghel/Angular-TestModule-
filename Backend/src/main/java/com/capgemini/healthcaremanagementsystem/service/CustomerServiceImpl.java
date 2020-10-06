package com.capgemini.healthcaremanagementsystem.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaremanagementsystem.dao.AppointmentDao;
import com.capgemini.healthcaremanagementsystem.dao.CenterDao;
import com.capgemini.healthcaremanagementsystem.dao.CustomerDao;
import com.capgemini.healthcaremanagementsystem.dao.TestDao;
import com.capgemini.healthcaremanagementsystem.entity.Appointment;
import com.capgemini.healthcaremanagementsystem.entity.Customer;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.AppointmentNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.CenterDoesNotExistsException;
import com.capgemini.healthcaremanagementsystem.exception.CenterNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.ContactNumberAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CustomerNameAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.CustomerNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.EmailAlreadyExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdDoesNotExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CenterDao centerDao;
	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public Customer registerCustomer(Customer customer)  {

		if (customerDao.findCustomerByCustomerName(customer.getCustomerName()) != null)
			throw new CustomerNameAlreadyExistException(
					"customer with Name " + customer.getCustomerName() + " is Already Exist");

		if (customerDao.findCustomerByCustomerPhoneNumber(customer.getCustomerPhoneNumber()) != null)
			throw new ContactNumberAlreadyExistException(
					"customer with ContactNumber " + customer.getCustomerPhoneNumber() + " is Already Exist");

		if (customerDao.findCustomerByCustomerEmail(customer.getCustomerEmail()) != null)
			throw new EmailAlreadyExistException(
					"customer with Email " + customer.getCustomerEmail() + " is Already Exist");

		customer = customerDao.save(customer);
		return customer;
	}
	
	@Override
	public Customer customerLogin(String customerName, String customerPassword){
		Customer customer = customerDao.findCustomerByCustomerName(customerName);
		if ((customer!=null && customer.getCustomerPassword().equals(customerPassword) && customer.getCustomerName().equals(customerName)))
			return customer;
		throw new CustomerNotFoundException(
				"Customer with CustomerName [" + customerName + "] and password [" + customerPassword + "] not found");
	}
	

	@Override
	public Test getTestById(Long id) {

			Optional<Test> testList = testDao.findById(id);
			if (testList.isPresent()) {
				return testList.get();
			} else {
				throw new TestIdDoesNotExistException("Test with "+ id+" not found!!");
			}
		}

	
	@Override
	public Appointment makeAppointment(@Valid Appointment appointment, Long customerId, Long testId) {
	  return customerDao.findById(customerId).map(customer -> 
	  {
	 appointment.setCustomer(customer); 		  
	 Test temptest= testDao.findById(testId).orElseThrow(() -> new TestIdDoesNotExistException("Test id not found!"));
	 appointment.setTest(temptest);
	 return appointmentDao.save(appointment);
	   }
	    ).orElseThrow(() -> new CenterNotFoundException("Center not found!"));
	  
	  }

	
	@Override
	public Appointment getAppointmentById(Long id) {
		Optional<Appointment> appointmentList = appointmentDao.findById(id);
		if (appointmentList.isPresent()) {
			return appointmentList.get();
		} else {
			throw new CenterDoesNotExistsException("Appointment with "+ id+" not found!!");
		}
	}
	

	@Override
	public List<Appointment> getAllAppointment() {
		if (appointmentDao.findAll().isEmpty()) {
			throw new AppointmentNotFoundException("Appointment list is empty");
		}
		List<Appointment> allAppointments = appointmentDao.findAll();
		return allAppointments;
	}

	}


