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
	
	@Column(name="startDate", nullable=false)
	Calendar startDate;
	
	@Column(name="endDate", nullable=false)
	Calendar endDate;
	
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
	if(startTime.get(Calendar.YEAR) != endTime.get(Calendar.YEAR) || startTime.get(Calendar.MONTH) != endTime.get(Calendar.MONTH) 
			|| startTime.get(Calendar.DAY_OF_MONTH) != endTime.get(Calendar.DAY_OF_MONTH))
			throw new IllegalArgumentException
			("Appointment overlapping multiple days.  If this is intended"
			+ "split into two appointments.");
		
		this.id = id;
		this.startDate = startTime;
		this.endDate = endTime;
		this.description = description;
		this.patient = patient;
		this.caregiver = caregiver;
		this.status = status;
	}

	

	public Appointment( User patient, Calendar startDate, Calendar endDate, String description) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.patient = patient;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getStartTime() {
		return startDate;
	}

	public void setStartTime(Calendar startTime) {
		this.startDate = startTime;
	}

	public Calendar getEndTime() {
		return endDate;
	}

	public void setEndTime(Calendar endTime) {
		this.endDate = endTime;
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
	
	/**
	 * An appointment is overlapping if either an end time of one overlaps
	 * the start time of another, or if the start t time of one overlaps
	 * the end time of another.
	 * @param b An appointment to check overlapping with.
	 * @return True if the appointments overlap, false if the do not.
	 */
	public boolean overlapsWith(Appointment b) {
			if(
					(
							b.getStartTime().before(this.getStartTime()) 
							&&
							b.getEndTime().after(this.getStartTime()) 
					)
					||
					(
							this.getStartTime().before(b.getStartTime())
							&&
							this.getEndTime().after(b.getStartTime())
					)
				)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	/**
	 * One appointment envelops another appointment if one appointment's duration is
	 * completely within the bounds of another.  Envenlops() checks not only if this
	 * appointment envelops b, be also vice-versa.
	 * @param b An appointment to test enveloping of.
	 * @return True of a envelops b, true if b envelops a, otherwise false.
	 */
	public boolean envelops(Appointment b) {
		if(
				(
						this.getStartTime().after(b.getStartTime()) 
						&&
						this.getStartTime().before(b.getEndTime())
				)
				||
				(
						b.getStartTime().after(this.getStartTime())
						&&
						b.getStartTime().before(this.getEndTime())
				)
			)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Compares two appointments that  belong to the same user, and checks
	 * scheduling one would constitute a schedule conflict with the other.
	 * @param b An appointment FROM THE SAME USER to test confliction with.
	 * @return True if appointments conflict, false otherwise.
	 */
	public boolean conflictsWith(Appointment b) {
		return (this.envelops(b) || this.overlapsWith(b));
	}
	
	public String dayOfTheWeek() {
		
		 String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thusday",
			        "Friday", "Saturday" };
			    // Day_OF_WEEK starts from 1 while array index starts from 0
			   
		 	return strDays[this.getStartTime().get(Calendar.DAY_OF_WEEK)];
	}

}
