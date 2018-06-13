package com.revature.seniorcare.beans;

import java.time.LocalDateTime;

/**
 * An availability block is a block of time in which a caregiver is open to accepting
 * appointments.  They are elements of a collection that represents a caregivers availability
 * over a given day, week, or more.
 * @author Sarah
 *
 */
public class AvailabilityBlock {
	private LocalDateTime start;
	private LocalDateTime end;

	public AvailabilityBlock() {
		// TODO Auto-generated constructor stub
	}

}
