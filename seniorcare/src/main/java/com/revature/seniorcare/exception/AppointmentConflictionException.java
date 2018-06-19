package com.revature.seniorcare.exception;

public class AppointmentConflictionException extends RuntimeException{

	  public AppointmentConflictionException() { super(); }
	  public AppointmentConflictionException(String message) { super(message); }
	  public AppointmentConflictionException(String message, Throwable cause) { super(message, cause); }
	  public AppointmentConflictionException(Throwable cause) { super(cause); }

}
