package com.revature.seniorcare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.CaregiverNote;
import com.revature.seniorcare.repository.AppointmentRepository;
import com.revature.seniorcare.repository.CaregiverNoteRepository;

@Service("CaregiverNoteService")
@Transactional
public class CaregiverNoteServiceImpl implements CaregiverNoteService{
	
	@Autowired
	private CaregiverNoteRepository caregiverNoteRepo;

	@Override
	public List<CaregiverNote> getAll() {
		return caregiverNoteRepo.findAll();
	}

	@Override
	public CaregiverNote findById(int id) {
		return caregiverNoteRepo.findOne(id);
	}
}
