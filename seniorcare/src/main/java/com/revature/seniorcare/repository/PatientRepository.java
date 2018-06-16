package com.revature.seniorcare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.seniorcare.beans.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	
	List<Patient> findAll();
	Optional<Patient> findById(int PatientID);
	Patient findByfirstName(String name);
	//list of possible queries    https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
}