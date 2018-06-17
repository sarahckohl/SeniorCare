package com.revature.seniorcare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.repository.PatientRepository;

@Service("PatientService")
@Transactional
public class PatientServiceImpl extends UserServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	
}
