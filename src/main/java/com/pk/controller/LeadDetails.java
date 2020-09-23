package com.pk.controller;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lead_details")
public class LeadDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length=100)
	private String firstName;
	@Column(length=100)
	private String lastName;
	@Column(length=100)
	private String email;
	@Column(length=20)
	private String mobileNo;
	@Column(length=100)
	private String subscribed;
	@Column(length=50)
	private String whereFrom;
	@Column(length=1000)
	private String description;
	@Column(length=100)
	private String registrationdDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(String subscribed) {
		this.subscribed = subscribed;
	}
	public String getWhereFrom() {
		return whereFrom;
	}
	public void setWhereFrom(String whereFrom) {
		this.whereFrom = whereFrom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegistrationdDate() {
		return registrationdDate;
	}
	public void setRegistrationdDate(String registrationdDate) {
		this.registrationdDate = registrationdDate;
	}

	
}
