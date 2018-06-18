package com.revature.seniorcare.service;

import java.util.List;

import com.revature.seniorcare.beans.Appointment;

public interface AppointmentService {
	
	List<Appointment> getAll();
	Appointment findById(int id);
	Appointment addAppointment(Appointment a);

}
