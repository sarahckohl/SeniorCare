package com.revature.seniorcare.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import com.revature.seniorcare.beans.Patient;
import com.revature.seniorcare.beans.User;

@Transactional
public interface PatientRepository extends UserBaseRepository<Patient>{
	
	public Optional<User> findByPreferences();
	public Optional<User> findByPreferredCaregivers();
	
	//list of possible queries    https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
}