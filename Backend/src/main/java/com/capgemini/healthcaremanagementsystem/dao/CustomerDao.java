package com.capgemini.healthcaremanagementsystem.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.healthcaremanagementsystem.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
	/**
	 * QueryByMethod 
	 */
	public Customer findCustomerByCustomerName(String customerName);

	public Customer findCustomerByCustomerPhoneNumber(BigInteger contactNumber);

	public Customer findCustomerByCustomerEmail(String customerEmail);

	public Customer findCustomerByCustomerId(Long customerId);
}
