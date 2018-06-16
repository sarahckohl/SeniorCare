package com.revature.seniorcare.service;

import java.util.List;

import com.revature.seniorcare.beans.CaregiverNote;

public interface CaregiverNoteService {
	
	List<CaregiverNote> getAll();
	CaregiverNote findById(int id);

}
