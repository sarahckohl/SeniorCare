package com.revature.seniorcare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Caregivers are users that are able to accept requests for appointments and make their
 * availability accessible to patients.
 * @author Sarah
 *
 */

@Component
@Entity
public class Caregiver extends User {
	
	@Column(unique = true)
	String licenseNumber;
	@Autowired
	Availability availability;
	
	public Caregiver(int id, String username, String email, String firstName, String lastName, int zipCode, String state,
			String city, String street, String licenseNumber) {
		super();
		this.licenseNumber = licenseNumber;
	}
	



}
