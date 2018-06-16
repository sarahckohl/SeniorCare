package com.revature.seniorcare.service;

import java.util.List;

import com.revature.seniorcare.beans.PatientNote;

public interface PatientNoteService {
	
	List<PatientNote> getAll();
	PatientNote findById(int id);

}
