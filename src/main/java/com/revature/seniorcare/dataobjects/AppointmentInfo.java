package com.revature.seniorcare.dataobjects;

import com.revature.seniorcare.beans.Appointment;

public class AppointmentInfo {
	private int aptID;
	private int patientID;
	private int NurseID;
	private String Description;
	private String startDateTime;
	private String endDateTime;
	
	public AppointmentInfo(Appointment apt) {
		this.aptID = apt.getId();
		this.patientID = apt.getPatient().getId();
		
		if (apt.getCaregiver() != null) {
		NurseID = apt.getCaregiver().getId();
		}
		
		Description = apt.getDescription();
		this.startDateTime = apt.getStartTime().getTime().toString();
		this.endDateTime = apt.getEndTime().getTime().toString();
	}
	
	public AppointmentInfo(int aptID, int patientID, int nurseID, String description, String startDateTime,
			String endDateTime) {
		super();
		this.aptID = aptID;
		this.patientID = patientID;
		NurseID = nurseID;
		Description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}
	
	public int getAptID() {
		return aptID;
	}
	public void setAptID(int aptID) {
		this.aptID = aptID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getNurseID() {
		return NurseID;
	}
	public void setNurseID(int nurseID) {
		NurseID = nurseID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	
	
}
