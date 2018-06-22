package com.revature.seniorcare.service;

import java.util.Calendar;
import java.util.List;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.AppointmentStatus;
import com.revature.seniorcare.beans.User;

public interface AppointmentService {
	
	List<Appointment> getAll();
	Appointment findById(int id);
	Appointment addAppointment(Appointment a);
	List<Appointment> findByCaregiver(User c);
	List<Appointment> findByPatient(int userid);
	List<Appointment> findByStatus(AppointmentStatus s);
//	Appointment joinAppointment(Appointment a);
	void getRequestedForWeek(Calendar cal);

}
