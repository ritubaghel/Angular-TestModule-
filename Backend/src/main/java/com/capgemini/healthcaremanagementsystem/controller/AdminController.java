package com.capgemini.healthcaremanagementsystem.controller;

import java.util.List;

import javax.persistence.PostUpdate;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaremanagementsystem.entity.Admin;
import com.capgemini.healthcaremanagementsystem.entity.Appointment;
import com.capgemini.healthcaremanagementsystem.entity.Center;
import com.capgemini.healthcaremanagementsystem.entity.Test;
import com.capgemini.healthcaremanagementsystem.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(value = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// Admin login
	@PostMapping("/login")
	public Admin adminLogin(@RequestBody Admin admin) {
		String adminName = admin.getAdminName();
		String adminPassword = admin.getAdminPassword();
		return adminService.adminLogin(adminName, adminPassword);
	}

	// Get all center
	@GetMapping("/centers")
	public List<Center> getAllCenter() {
		return adminService.getAllCenter();
	}

	// Get center by id
	@GetMapping("/centers/{id}")
	public Center getCenterById(@PathVariable Long id) {
		return adminService.getCenterById(id);

	}
	
	// Get all test
		@GetMapping("/tests")
		public List<Test> getAllTest() {
			return adminService.getAllTest();
		}

	// Create center
	@PostMapping("/center")
	public Center createStudent(@Valid @RequestBody Center center) {
		return adminService.createCenter(center);

	}

	// Delete center
	@DeleteMapping("/center/{id}")
	public String deleteCenter(@PathVariable Long id) {
		return adminService.deleteCenter(id);
	}

	// Add tests to center
	@PostMapping("/centers/{centerId}/tests")
	public Test addTest(@PathVariable Long centerId, @Valid @RequestBody Test test) {
		return adminService.addTest(centerId, test);
	}

	

	// Delete Test
	@DeleteMapping("/deletetest/{id}")
	public boolean deleteTest(@PathVariable Long id) {
		return adminService.deleteaTest(id);
	}

	@PutMapping("/approveAppointments/appointmentId/{appointmentId}")
	public Appointment approveAppointment(@PathVariable long appointmentId) {
		return adminService.approveAppointment(appointmentId);
	}

	@PutMapping("/rejectAppointments/appointmentId/{appointmentId}")
	public Appointment rejectAppointment(@PathVariable long appointmentId) {
		return adminService.rejectAppointment(appointmentId);
	}

}