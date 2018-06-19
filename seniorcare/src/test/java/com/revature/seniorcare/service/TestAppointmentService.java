package com.revature.seniorcare.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import com.revature.seniorcare.beans.Appointment;

class TestAppointmentService {

	@Test
	void test() {
		Calendar date = Calendar.getInstance();
		date.set(2018, 9, 22, 5, 0);
		Calendar date2 = Calendar.getInstance();
		date.set(2018, 9, 22, 6, 0);
		
		Calendar date3 = Calendar.getInstance();
		date.set(2018, 9, 22, 7, 0);
		Calendar date4 = Calendar.getInstance();
		date.set(2018, 9, 22, 8, 0);
		
		Appointment before = new Appointment(1, date, date2, null, null, null, null);
		Appointment after = new Appointment(2, date3, date4, null, null, null, null);
		Appointment overlappinga = new Appointment(1, date, date3, null, null, null, null);
		Appointment overlappingb = new Appointment(2, date2, date4, null, null, null, null);
		Appointment envelopinga = new Appointment(1, date, date4, null, null, null, null);
		Appointment envlopingb = new Appointment(2, date2, date3, null, null, null, null);
	}

}
