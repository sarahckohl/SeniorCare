package com.revature.seniorcare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.seniorcare.beans.Caregiver;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer>{
	
	
	List<Caregiver> findAll();
	Optional<Caregiver> findById(int PatientID);
	//list of possible queries    https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
	
}