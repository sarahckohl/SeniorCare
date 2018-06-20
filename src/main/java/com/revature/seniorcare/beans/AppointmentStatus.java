package com.revature.seniorcare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Appointment status indicates the valid values for the state an appointment can be
 * in.
 * @author Sarah
 *
 */

@Component
@Entity
@Table(name="AppointmentStatus")
public class AppointmentStatus {

	@Id
	@Column(name="GENRE_ID")
	@SequenceGenerator(name="Apt_sts_SEQ", sequenceName="Apt_sts_SEQ")	
	@GeneratedValue(generator="Apt_sts_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;

	@Column(name="status", nullable=false)
	private String status;
	
	public AppointmentStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AppointmentStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
