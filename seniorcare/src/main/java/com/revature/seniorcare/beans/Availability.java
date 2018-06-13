package com.revature.seniorcare.beans;

import java.util.ArrayList;

/**
 * Availability is a collection of all availability blocks a caregiver is offering to
 * their clients.   An availability is different from a schedule in the sense that
 * it is static-- it will not be modified as a patient accepts and declines appointments.
 * It merely denotes the "operating hours" of the caregiver.
 * @author Sarah
 *
 */
public class Availability {
	
	private ArrayList<AvailabilityBlock> availability;

	public Availability() {
		// TODO Auto-generated constructor stub
	}

}
