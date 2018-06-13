package com.revature.seniorcare.beans;

import java.time.LocalDateTime;

/**
 * Appointments are blocks of time that can be added to a patient and/or caregiver's
 * schedule along with associated information about the nature of the appointment.
 * 
 * The appointment also contains methods for comparing one appointment to another
 * to assess their compatibility with each other.
 * @author Sarah
 *
 */
public class Appointment {
	
	LocalDateTime startTime;
	LocalDateTime endTime;
	String description;
	Patient patient;
	Caregiver caregiver;
	AppointmentStatus status;
	
	
	

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

}
