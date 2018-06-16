package com.revature.seniorcare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.PatientNote;
import com.revature.seniorcare.repository.PatientNoteRepository;

@Service("PatientNoteService")
@Transactional
public class PatientNoteServiceImpl implements PatientNoteService{
	
	@Autowired
	private PatientNoteRepository patientNoteRepo;

	@Override
	public List<PatientNote> getAll() {
		return patientNoteRepo.findAll();
	}

	@Override
	public PatientNote findById(int id) {
		return patientNoteRepo.findOne(id);
	}

}
