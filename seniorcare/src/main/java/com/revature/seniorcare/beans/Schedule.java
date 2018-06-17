package com.revature.seniorcare.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
public class Schedule {
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "APPOINTMENT_ID")
	Set<Appointment> schedule;

	public Schedule() {
		// TODO Auto-generated constructor stub
		schedule = new HashSet<Appointment>();
	}

}
