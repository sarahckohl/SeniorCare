package com.revature.seniorcare.beans;

/**
 * Appointment status indicates the valid values for the state an appointment can be
 * in.
 * @author Sarah
 *
 */
public enum AppointmentStatus {
	PENDING_NURSE_APPROVAL,
	PENDING_PATIENT_APPROVAL,
	CONFIRMED,
	NURSE_AVAILABILITY,
	CANCELLED,
	COMPLETE
}
