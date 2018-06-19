package com.revature.seniorcare.controllers;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.service.UserService;

@Controller
@RestController(value = "/users")
public class UserController {

	static {
		System.out.println("in login controller");
	}
	

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String loadLogin(HttpSession session) {
		if(session.getAttribute("user")!=null) {
			//redirect to home page
		}
		System.out.println("GET Login");
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(HttpServletRequest req) {
		System.out.println("Go.");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("IN LOGIN --POST. Attempting to log in user " +
				username + " with password "+ password);
		Optional<User> u = userService.login(username, password);
		if(u == null) {
			return "redirect:login";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			return "redirect:home";
		}
	}
	
}
