package com.revature.seniorcare.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Schedules")
public class Schedule {
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name="SCH_ID_SEQ_GEN", sequenceName="SCH_ID_SEQ")	
	@GeneratedValue(generator="SCH_ID_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "APPOINTMENT_ID")
	Set<Appointment> schedule;

	public Schedule() {
		// TODO Auto-generated constructor stub
		schedule = new HashSet<Appointment>();
	}

}
