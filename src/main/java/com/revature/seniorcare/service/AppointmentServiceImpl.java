package com.revature.seniorcare.service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.AppointmentStatus;
import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.exception.AppointmentConflictionException;
import com.revature.seniorcare.repository.AppointmentRepository;
import com.revature.seniorcare.repository.UserRepository;

@Service("AppointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Appointment> getAll() {
		return appointmentRepo.findAll();
	}

	@Override
	public Appointment findById(int id) {
		return appointmentRepo.findOne(id);
	}

	
	/*
	 * addAppointment is called when a patient submits an appointment for care
	 * (a POST request).  It is not concerned with the schedule of the caregiver
	 * as a caregiver signs onto an appointment by PUTing their name to an existing
	 * appointment. If the desired action is to commit a caregiver to an appointment,
	 * call {@link #joinAppointment}.
	 * @see com.revature.seniorcare.service.AppointmentService#addAppointment
	 * (com.revature.seniorcare.beans.Appointment)
	 */
	@Override
	public Appointment addAppointment(Appointment a) {
		
		if(!appointmentIsValidForPatient(a))
		{
			throw new AppointmentConflictionException("Patient already has"
					+ "an appointment within the times specified.");
		}
		else {
		appointmentRepo.save(a);
		return a;
		}
	}
	
	/**
	 *Join appointment is called when a caregiver (for now) wants sign
	 * on to a appointment.  It edits (PUTS) a caregiver the appointment 
	 * such that the persisted appointment now has a non-null caregiver column.
	 * @param a An existing patient-requested appointment to be signed onto by
	 * a caregiver.
	 * @return The modified appointment.
	 */
	public Appointment joinAppointment(Appointment a)
	{
		if(!appointmentIsValidForPatient(a))
		{
			throw new AppointmentConflictionException("Caregiver already has"
					+ "an appointment within the times specified.");
		} else {
			appointmentRepo.save(a);
			return a;
		}
	}

	@Override
	public List<Appointment> findByCaregiver(User c) {
		return appointmentRepo.findByCaregiver(c);
	}

	@Override
	public List<Appointment> findByPatient(User p) {
		return appointmentRepo.findByPatient(p);
	}

	@Override
	public List<Appointment> findByStatus(AppointmentStatus s) {
		return appointmentRepo.findByStatus(s);
	}
	
	/**
	 * Checks that a new appointment can be added to an existing caregiver's schedule.
	 * @param newAppointment the appointment to be added.
	 * @return true if there is no scheduling conflict, otherwise false.
	 */
	public boolean appointmentIsValidForCaregiver(Appointment newAppointment) {
		
		//find all appointments with this caregiver
		/*
		 * TODO we could search a smaller domain if we implement DAO queries that find by
		 * date & user and then only check for conflicts for appointments on the same day.
		 */
		List<Appointment> existingAppointments = 
				appointmentRepo.findByCaregiver(newAppointment.getCaregiver());
		
		for(Appointment existingAppointment : existingAppointments) {
			if(newAppointment.conflictsWith(existingAppointment))
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Checks that a new appointment can be added to an existing caregiver's schedule.
	 * @param newAppointment the appointment to be added.
	 * @return true if there is no scheduling conflict, otherwise false.
	 */
	public boolean appointmentIsValidForPatient(Appointment newAppointment) {
		
		//find all appointments with this caregiver
		/*
		 * TODO we could search a smaller domain if we implement DAO queries that find by
		 * date & user and then only check for conflicts for appointments on the same day.
		 */
		List<Appointment> existingAppointments = 
				appointmentRepo.findByPatient(newAppointment.getPatient());
		
		for(Appointment existingAppointment : existingAppointments) {
			if(newAppointment.conflictsWith(existingAppointment))
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void getRequestedForWeek(Calendar dateMonday) {
		Calendar dateFriday = dateMonday;
		dateFriday.add(Calendar.DAY_OF_MONTH, 5);
		
		appointmentRepo.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(dateMonday, dateFriday);
		
	}
}
