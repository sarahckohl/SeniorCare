package com.revature.seniorcare.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import com.revature.seniorcare.beans.Caregiver;
import com.revature.seniorcare.beans.User;

@Transactional
public interface CaregiverRepository extends UserBaseRepository<Caregiver>{
	
	public Optional<User> getByLicenseNumber(int number);
	//TODO get by availability and schedule
	//list of possible queries    https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
	
}