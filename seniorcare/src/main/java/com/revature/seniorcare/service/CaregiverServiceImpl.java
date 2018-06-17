package com.revature.seniorcare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.Caregiver;
import com.revature.seniorcare.repository.AppointmentRepository;
import com.revature.seniorcare.repository.CaregiverRepository;

@Service("CaregiverService")
@Transactional
public class CaregiverServiceImpl extends UserServiceImpl implements CaregiverService{
	
	@Autowired
	private CaregiverRepository caregiverRepo;


}
