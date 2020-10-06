package com.capgemini.healthcaremanagementsystem.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tests")
 
public class Test{
	
	
	@Id
    @GeneratedValue
	private Long testId;
	
	@Column(name = "testName")
	private String testName;
	
	@Column(name = "testPrice")
	private int testPrice;

	@ManyToOne()
    @JoinColumn(name = "center_id", nullable = false)
    @JsonIgnore
    private Center center;
	
	@OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private Set<Appointment> Appointments;
	
	public Set<Appointment> getAppointments() {
		return Appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		Appointments = appointments;
	}

	public Test() {}

	public Test(String testName, int testPrice) {
		super();
		this.testName = testName;
		this.testPrice = testPrice;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(int testPrice) {
		this.testPrice = testPrice;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
	
}