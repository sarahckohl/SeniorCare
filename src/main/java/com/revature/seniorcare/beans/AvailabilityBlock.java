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
	@Column(name="AvailabilityBlock_ID")
	int id;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "starttime", nullable = false)
    private Calendar starttime;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endtime", nullable = false)
    private Calendar endtime;

	public AvailabilityBlock() {
		// TODO Auto-generated constructor stub
	}
	
	public AvailabilityBlock(int id, Calendar start, Calendar end) {
		super();
		
		if(start.after(end)) throw new IllegalArgumentException
			("Start time occurs after end time.");
		if(start.YEAR != end.YEAR || start.MONTH != end.MONTH 
				|| start.DAY_OF_MONTH != end.DAY_OF_MONTH)
				throw new IllegalArgumentException
				("Availability overlapping multiple days.  If this is intended"
				+ "split into two availabilities.");
		this.id = id;
		this.starttime = start;
		this.endtime = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getStart() {
		return starttime;
	}


	public Calendar getEnd() {
		return endtime;
	}
	
	

}