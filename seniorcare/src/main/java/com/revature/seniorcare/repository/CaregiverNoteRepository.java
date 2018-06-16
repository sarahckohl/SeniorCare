package com.revature.seniorcare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.seniorcare.beans.CaregiverNote;

@Repository
public interface CaregiverNoteRepository extends JpaRepository<CaregiverNote, Integer>{
	
	List<CaregiverNote> findAll();
	Optional<CaregiverNote> findById(int PatientID);
	//list of possible queries    https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
	
}