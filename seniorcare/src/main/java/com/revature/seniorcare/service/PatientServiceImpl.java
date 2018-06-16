package com.revature.seniorcare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Patient;
import com.revature.seniorcare.repository.PatientRepository;

@Service("PatientService")
@Transactional
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepository patientRepo;

	@Override
	public List<Patient> getAll() {
		return patientRepo.findAll();
	}

	@Override
	public Patient findById(int id) {
		return patientRepo.findOne(id);
	}

	@Override
	public Patient findByName(String name) {
		return patientRepo.findByfirstName(name);
	}

}
