//package com.revature.seniorcare.beans;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.util.Calendar;
//
//import org.junit.jupiter.api.Test;
//
//class TestAppointment {
//
//	@Test
//	void test() {
//		
//		Calendar start = Calendar.getInstance();
//		Calendar end = Calendar.getInstance();
//		Calendar differentDay = Calendar.getInstance();
//
//		
//		start.set(Calendar.HOUR_OF_DAY, 9);
//		end.set(Calendar.HOUR_OF_DAY, 12);
//		differentDay.set(Calendar.DAY_OF_MONTH, differentDay.get(Calendar.DAY_OF_MONTH)+1);
//		
//		
//		//Valid appointment
//		Appointment a = new Appointment(0, start, end, "eh", null,
//				null, null);
//		
//		//Invalid appointment (end before start)
//		
//		assertThrows(IllegalArgumentException.class, 
//				
//				()->{			
//					Appointment b = new Appointment(0, end, start, "eh", null,
//							null, null);
//		            }
//				, "End before start.");
//		
//		
//		assertThrows(IllegalArgumentException.class, 
//				
//				()->{			
//					Appointment b = new Appointment(0, start, differentDay, "eh", null,
//							null, null);
//		            }
//				, "Different days.");	
//		
//
//				
//		
//
//
//	}
//
//}
