package com.revature.seniorcare.service;

import java.util.List;

import com.revature.seniorcare.beans.Caregiver;

public interface CaregiverService {
	
	List<Caregiver> getAll();
	Caregiver findById(int id);

}
