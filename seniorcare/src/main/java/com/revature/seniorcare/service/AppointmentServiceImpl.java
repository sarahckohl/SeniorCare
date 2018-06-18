package com.revature.seniorcare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.repository.AppointmentRepository;

@Service("AppointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepo;

	@Override
	public List<Appointment> getAll() {
		return appointmentRepo.findAll();
	}

	@Override
	public Appointment findById(int id) {
		return appointmentRepo.findOne(id);
	}

	@Override
	public Appointment addAppointment(Appointment a) {
		appointmentRepo.save(a);
		return a;
	}
}
