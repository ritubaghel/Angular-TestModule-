package com.capgemini.healthcaremanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaremanagementsystem.entity.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {
	
}
