package com.revature.seniorcare.beans;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

/**
 * Appointments are blocks of time that can be added to a patient and/or caregiver's
 * schedule along with associated information about the nature of the appointment.
 * 
 * The appointment also contains methods for comparing one appointment to another
 * to assess their compatibility with each other.
 * @author Sarah
 * + AlEx
 */

@Component
@Entity
@Table(name="Appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APT_ID_SEQ")
	@SequenceGenerator(name="APT_ID_SEQ", sequenceName="appointment_seq", allocationSize=1)
	@Column(name="APPOINTMENT_ID")
	int id;
	
	@Column(name="startTime", nullable=false)
	Calendar startTime;
	
	@Column(name="endTime", nullable=false)
	Calendar endTime;
	
	@Column(name="description", nullable=false)
	String description;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="patient")
	User patient;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="Caregiver")
	User caregiver;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="AppointmentStatus", nullable=false)
	AppointmentStatus status;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name="APPOINTMENTS_NOTES",
			joinColumns=@JoinColumn(name="appointment_ID"),
			inverseJoinColumns=@JoinColumn(name="NOTE_ID"))
	private Set<Note> Note;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name="APPOINTMENTS_SERVICES",
			joinColumns=@JoinColumn(name="appointment_ID"),
			inverseJoinColumns=@JoinColumn(name="Caregivingservice_ID"))
	private Set<CaregivingServices> requestedServices;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name="APPOINTMENT_NOTES",
			joinColumns=@JoinColumn(name="appointment_ID"),
			inverseJoinColumns=@JoinColumn(name="Note_ID"))
	private Set<Note> aptNotes;

	public Appointment() {

	}

	
	public Appointment(int id, Calendar startTime, Calendar endTime, String description, User patient,
			User caregiver, AppointmentStatus status) {
		super();
		
		if(startTime.after(endTime)) throw new IllegalArgumentException
		("Start time occurs after end time.");
	if(startTime.YEAR != endTime.YEAR || startTime.MONTH != endTime.MONTH 
			|| startTime.DAY_OF_MONTH != endTime.DAY_OF_MONTH)
			throw new IllegalArgumentException
			("Appointment overlapping multiple days.  If this is intended"
			+ "split into two appointments.");
		
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.patient = patient;
		this.caregiver = caregiver;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public User getCaregiver() {
		return caregiver;
	}

	public void setCaregiver(User caregiver) {
		this.caregiver = caregiver;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
	
	

}
