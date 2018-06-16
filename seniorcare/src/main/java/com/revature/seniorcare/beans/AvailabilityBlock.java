package com.revature.seniorcare.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * An availability block is a block of time in which a caregiver is open to accepting
 * appointments.  They are elements of a collection that represents a caregivers availability
 * over a given day, week, or more.
 * @author Sarah
 *
 */

@Component
@Entity
@Table(name="AvailabilityBlock")
public class AvailabilityBlock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AV_blc_id_seq")
	@SequenceGenerator(name="AV_blc_id_seq", sequenceName="AV_blc_id_seq", allocationSize=1)
	@Column(name="Availability_Block_ID")
	int id;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start", nullable = false)
    private Calendar start;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end", nullable = false)
    private Calendar end;

	public AvailabilityBlock() {
		// TODO Auto-generated constructor stub
	}
	
	public AvailabilityBlock(int id, Calendar start, Calendar end) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getEnd() {
		return end;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}
	
	

}
