package com.revature.seniorcare.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

/**
 * Availability is a collection of all availability blocks a caregiver is offering to
 * their clients.   An availability is different from a schedule in the sense that
 * it is static-- it will not be modified as a patient accepts and declines appointments.
 * It merely denotes the "operating hours" of the caregiver.
 * @author Sarah
 *
 */
@Component
public class Availability {
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "AVAILABILITY_ID")
	private Set<AvailabilityBlock> availability;

	public Availability() {
		// TODO Auto-generated constructor stub
		this.availability = new HashSet<AvailabilityBlock>();
	}

}
