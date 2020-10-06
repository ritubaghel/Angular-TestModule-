package com.capgemini.healthcaremanagementsystem.entity;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
    @GeneratedValue
	private Long customerId;
	
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "customerPassword")
	private String customerPassword;
	
	@Column(name = "customerPhoneNumber")
	private BigInteger customerPhoneNumber;
	
	@Column(name = "customerEmail")
	private String customerEmail;
	
	@Column(name = "customerAge")
	private int customerAge;
	
	@Column(name = "customerGender")
	private String customerGender;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

	public Customer() {
		super();
	}

	public Customer(String customerName, String customerPassword, BigInteger customerPhoneNumber, String customerEmail,
			int customerAge, String customerGender) {
		super();
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerEmail = customerEmail;
		this.customerAge = customerAge;
		this.customerGender = customerGender;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public BigInteger getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(BigInteger customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	
	
	

}
