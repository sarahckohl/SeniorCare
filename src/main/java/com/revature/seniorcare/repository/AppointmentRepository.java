package com.revature.seniorcare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.AppointmentStatus;
import com.revature.seniorcare.beans.User;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	
	List<Appointment> findAll();
	Optional<Appointment> findById(int AppointmentID);
	List<Appointment> findByCaregiver(User c);
	List<Appointment> findByPatient(User p);
	List<Appointment> findByStatus(AppointmentStatus s);
	//list of possible queries    https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
	
}