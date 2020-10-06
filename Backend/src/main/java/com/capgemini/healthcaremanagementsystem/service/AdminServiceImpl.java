package com.capgemini.healthcaremanagementsystem.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaremanagementsystem.dao.AdminDao;
import com.capgemini.healthcaremanagementsystem.dao.AppointmentDao;
import com.capgemini.healthcaremanagementsystem.dao.CenterDao;
import com.capgemini.healthcaremanagementsystem.dao.TestDao;
import com.capgemini.healthcaremanagementsystem.entity.Admin;
import com.capgemini.healthcaremanagementsystem.entity.Appointment;
import com.capgemini.healthcaremanagementsystem.entity.Center;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.exception.AdminNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.CenterDoesNotExistsException;
import com.capgemini.healthcaremanagementsystem.exception.CenterNotFoundException;
import com.capgemini.healthcaremanagementsystem.exception.TestIdDoesNotExistException;
import com.capgemini.healthcaremanagementsystem.exception.TestNotFoundException;

@Service

public class AdminServiceImpl implements AdminService {

	@Autowired
	private CenterDao centerDao;

	@Autowired
	private TestDao testDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Override
	public Admin adminLogin(String adminName, String adminPassword) throws AdminNotFoundException{
		Admin admin = adminDao.findAdminByAdminName(adminName);
		if ((admin!=null && admin.getAdminPassword().equals(adminPassword) && admin.getAdminName().equals(adminName)))
			return admin;
		throw new AdminNotFoundException(
				"Admin with AdminName [" + adminName + "] and password [" + adminPassword + "] not found");
	}
	

	// get all center
	@Override
	public List<Center> getAllCenter() {
		return centerDao.findAll();
	}

	// get center by id
	@Override
	public Center getCenterById(Long id) {
		Optional<Center> centerList = centerDao.findById(id);
		if (centerList.isPresent()) {
			return centerList.get();
		} else {
			throw new CenterDoesNotExistsException("Center with "+ id+" not found!!");
		}
	}

	// create center
	@Override
	public Center createCenter(@Valid Center center) {
		return centerDao.save(center);
	}

	// delete center
	@Override
	public String deleteCenter(Long id) {
		return centerDao.findById(id).map(center -> {
			centerDao.delete(center);
			return "Delete Successfully!";
		}).orElseThrow(() -> new CenterDoesNotExistsException("Center with "+ id+" not found!!"));
	}


	// Add tests to center
	@Override
	public Test addTest(Long centerId, @Valid Test test) {
		return centerDao.findById(centerId).map(center -> {
			test.setCenter(center);
			return testDao.save(test);
		}).orElseThrow(() -> new CenterNotFoundException("Center not found!"));

	}


	
	@Override
	public Appointment approveAppointment(Long  appointmentId) {
		Optional<Appointment> appointment =  appointmentDao.findById(appointmentId);
		Appointment app = appointment.get();
		app.setAppointmentStatus("Accepted");
		
		return appointmentDao.save(app);
	}


	@Override
	public Appointment rejectAppointment(Long appointmentId) {
		Optional<Appointment> appointment =  appointmentDao.findById(appointmentId);
		Appointment app = appointment.get();
		app.setAppointmentStatus("Reject");
		 
		return appointmentDao.save(app);
	}

	
	//Delete Test by Id
	@Override
	public boolean deleteaTest(Long id) {
		if(testDao.findById(id)!=null) {
			testDao.deleteById(id);
			return true; 
		}
		throw new TestNotFoundException("Test not found!!");
		
	}


	@Override
	public List<Test> getAllTest() {
			return testDao.findAll();
		}

	
	
	
	
	
	
	}



	

