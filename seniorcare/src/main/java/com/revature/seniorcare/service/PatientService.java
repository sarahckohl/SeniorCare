package com.revature.seniorcare.service;

import java.util.List;

import com.revature.seniorcare.beans.Patient;

public interface PatientService {
	
	List<Patient> getAll();
	Patient findById(int id);
	Patient findByName(String name);

}
