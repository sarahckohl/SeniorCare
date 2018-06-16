package com.revature.seniorcare.beans;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

/**
 * Patients are users that can make requests for appointments.
 * @author Sarah
 *
 */

@Component
@Entity
@Table(name="PATIENTS")
public class Patient {
	
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name="PNT_ID_SEQ_GEN", sequenceName="PNT_ID_SEQ")	
	@GeneratedValue(generator="PNT_ID_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	int id;
	
	
	@Column(name="username", nullable=false)
	private String username;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="firstName", nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="zipCode", nullable=false)
	private int zipCode;
	
	@Column(name="state", nullable=false)
	private String state;
	
	@Column(name="city", nullable=false)
	private String city;
	
	@Column(name="street", nullable=false)
	private String street;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "PATIENT_APPOINTMENT_ID")
	private Set<Appointment> schedule;

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name="PATIENTS_PREFERENCES",
			joinColumns=@JoinColumn(name="patient_ID"),
			inverseJoinColumns=@JoinColumn(name="preference_ID"))
	private Set<Preference> preferences;

	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name="PATIENTS_PREFEREd_Caregivers",
			joinColumns=@JoinColumn(name="patient_ID"),
			inverseJoinColumns=@JoinColumn(name="caregiver_ID"))
	private Set<Caregiver> preferedCaregivers;
	
	
	public Patient(int id, String username, String email, String firstName, String lastName, int zipCode, String state,
			String city, String street, Set<Appointment> schedule) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.state = state;
		this.city = city;
		this.street = street;
		this.schedule = schedule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Set<Appointment> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Appointment> schedule) {
		this.schedule = schedule;
	}

	public Patient() {
		// TODO Auto-generated constructor stub
	}

}
