package com.capgemini.healthcaremanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaremanagementsystem.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long>{
	/**
	 * QueryByMethod 
	 */
	public Admin findAdminByAdminName(String adminName);

}
