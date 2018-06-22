package com.revature.seniorcare.dataobjects;

import java.util.Set;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.AvailabilityBlock;

public class ScheduleInfo {
	
	private Set<Appointment> userApts;
	private AvailabilityBlock[] nurseAvail;
	
	public ScheduleInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Appointment> getUserApts() {
		return userApts;
	}
	public void setUserApts(Set<Appointment> userApts) {
		this.userApts = userApts;
	}
	public AvailabilityBlock[] getNurseAvail() {
		return nurseAvail;
	}
	public void setNurseAvail(AvailabilityBlock[] nurseAvail) {
		this.nurseAvail = nurseAvail;
	}
	
	
}
