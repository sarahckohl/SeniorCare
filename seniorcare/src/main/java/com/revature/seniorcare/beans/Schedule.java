package com.revature.seniorcare.beans;

import java.util.ArrayList;


/**
 * The schedule is essentially a collection of all appointments associated with a given
 * user (patient or caregiver).  A caregiver's schedule will contain all appointments
 * for which they have agreed to attend.  A patient's schedule will contain all appointments
 * which they have requested.  The Schedule class contains methods for comparing patient schedules
 * to caregiver schedules to check for compatibility.
 * @author Sarah
 *
 */
public class Schedule {

	/*TODO discuss the merits of implementing this as a hashable and/or adding
	 * additional classes (day, week, month, year) so that
	 * we can do a "bucket search" to narrow an appointment down to a given day or week
	 * and then perform appointment method comparions on a smaller data set than
	 * "the entire schedule"
	 */
	ArrayList<Appointment> schedule;

	public Schedule() {
		// TODO Auto-generated constructor stub
	}

}
