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
public class Patient extends User {
	

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name="PATIENTS_PREFEREd_Caregivers",
			joinColumns=@JoinColumn(name="patient_ID"),
			inverseJoinColumns=@JoinColumn(name="caregiver_ID"))
	private Set<Caregiver> preferedCaregivers;
	
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name="PATIENTS_PREFERENCES",
			joinColumns=@JoinColumn(name="patient_ID"),
			inverseJoinColumns=@JoinColumn(name="preference_ID"))
	private Set<Preference> preferences;	
	

}
