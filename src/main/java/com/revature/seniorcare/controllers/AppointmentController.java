package com.revature.seniorcare.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.dataobjects.AppointmentInfo;
import com.revature.seniorcare.dataobjects.ScheduleInfo;
import com.revature.seniorcare.dataobjects.UserInfo;
import com.revature.seniorcare.service.AppointmentService;
import com.revature.seniorcare.service.AvailabiltyBlockService;
import com.revature.seniorcare.service.UserService;

@Controller
public class AppointmentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AppointmentService aptService;
	
	@Autowired
	private AvailabiltyBlockService avlblkService;
	
	
	@RequestMapping(value = "/getSchedule", method=RequestMethod.GET)
	public ResponseEntity<ScheduleInfo> login(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("request recieved");
		
		String temp = req.getParameter("userid");
		int userid = Integer.valueOf(temp);
		String userrole = req.getParameter("userrole");
		String weekDate = req.getParameter("weekdate");
		
		ScheduleInfo weekSchedule = new ScheduleInfo();
		
		Optional<User> user = userService.findById(userid);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH);
		
		try {
			cal.setTime(sdf.parse(weekDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		weekSchedule.setUserApts(user.get().getScheduleByWeek(cal));
		
		if (userrole.equals("Patient")) {
			
			avlblkService.getAllForWeek(cal);
			
		} else if (userrole.equals("Caregiver")) {
			
			aptService.getRequestedForWeek(cal);
			
		}
		
		return new ResponseEntity<ScheduleInfo>(weekSchedule, HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/newappointment", method=RequestMethod.GET)
	public ResponseEntity<AppointmentInfo> register(HttpServletRequest req, HttpServletResponse resp) {
		String temp = req.getParameter("userid");
		int userid = Integer.valueOf(temp);
		
		Calendar startDateTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm", Locale.ENGLISH);
		
		temp = req.getParameter("startdatetime");
		
		try {
			startDateTime.setTime(sdf.parse(temp));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar endDateTime = Calendar.getInstance();
		
		temp = req.getParameter("enddatetime");
		
		try {
			endDateTime.setTime(sdf.parse(temp));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		String description = req.getParameter("description");
		
		User creator = userService.findById(userid).get();
		System.out.println(creator.getSchedule().toString());
		
		System.out.println(creator.toString() + " start: " +startDateTime.getTime()+ " end: " + endDateTime.getTime() + " desc: "+ description);
		
		Appointment newApt = new Appointment(creator, startDateTime, endDateTime, description);
		
		aptService.addAppointment(newApt);
		
		AppointmentInfo aptinfo = new AppointmentInfo(newApt);
		
		return new ResponseEntity<AppointmentInfo>(aptinfo, HttpStatus.FOUND);
	}
	
	
}
