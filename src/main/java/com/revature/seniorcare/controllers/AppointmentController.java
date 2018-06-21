package com.revature.seniorcare.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.service.AppointmentService;

@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService aptService;
	
	
	@RequestMapping(value = "/getSchedule", method=RequestMethod.GET)
	public String login(HttpServletRequest req, HttpServletResponse resp) {
		String userid = req.getParameter("userid");
		String userrole = req.getParameter("userrole");
		
		
		return null;
	}
	
	@RequestMapping(value = "/newappointment", method=RequestMethod.GET)
	public String register(HttpServletRequest req, HttpServletResponse resp) {
		
		return null;
	}
	
	
}
