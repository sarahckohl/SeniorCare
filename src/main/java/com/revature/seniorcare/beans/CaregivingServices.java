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
 * Caregiving Services describes the types of
 * services that can be rendered to a client.
 * @author Sarah
 *
 */

@Component
@Entity
@Table(name="CaregivingServices")
public class CaregivingServices {

	@Id
	@Column(name="CG_service_ID")
	@SequenceGenerator(name="CG_service_ID_SEQ", sequenceName="CG_service_ID_SEQ")	
	@GeneratedValue(generator="CG_service_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;

	@Column(name="CaregivingService", nullable=false)
	private String CaregivingService;
	
	public CaregivingServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaregivingServices(int id, String status) {
		super();
		this.id = id;
		this.CaregivingService = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return CaregivingService;
	}

	public void setStatus(String status) {
		this.CaregivingService = status;
	}
	
	
}
