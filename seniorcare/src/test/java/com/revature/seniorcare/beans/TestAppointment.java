package com.revature.seniorcare.beans;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class TestAppointment {

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
		
		System.out.println(date.get(Calendar.YEAR)+"-" + date.get(Calendar.MONTH)+"-" + date.get(Calendar.DAY_OF_MONTH));
		
		Appointment before = new Appointment(1, date, date2, null, null, null, null);
		Appointment after = new Appointment(2, date3, date4, null, null, null, null);
		Appointment overlappinga = new Appointment(1, date, date3, null, null, null, null);
		Appointment overlappingb = new Appointment(2, date2, date4, null, null, null, null);
		Appointment envelopinga = new Appointment(1, date, date4, null, null, null, null);
		Appointment envlopingb = new Appointment(2, date2, date3, null, null, null, null);
		
//		assertThrows(IllegalArgumentException.class,
//	            ()->{
//	            	new Appointment(2, date4, date, null, null, null, null);
//	            });
		
	}

}
