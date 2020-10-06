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
@Table(name = "centers")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Center{
	
	@Id
    @GeneratedValue
	private Long centerId;
	
	@Column(name = "centerName")
	private String centerName;
	
	@Column(name = "contactNumber")
	private BigInteger contactNumber;
	
	@Column(name = "location")
	private String location;
		
    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL)
    private Set<Test> tests;

	public Center(String centerName, BigInteger contactNumber, String location) {
		super();
		this.centerName = centerName;
		this.contactNumber = contactNumber;
		this.location = location;
	}

	public Center() {
		super();
	}



	public Long getCenterId() {
		return centerId;
	}



	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}



	public String getCenterName() {
		return centerName;
	}



	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}



	public BigInteger getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(BigInteger contactNumber) {
		this.contactNumber = contactNumber;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Set<Test> getTests() {
		return tests;
	}



	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	
	
}

