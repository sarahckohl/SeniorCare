package com.revature.seniorcare.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String Login(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println("IN LOGIN --GET. Attempting to log in user " +
				username + " with password "+ password);
		Optional<User> u = userService.login(username, password);
		
		
		
		if(u != null) {
			System.out.println(u.toString());
			HttpSession session = req.getSession();
			session.setAttribute("userid", u.get().getId());
			session.setAttribute("userrole", u.get().getUserrole());
			session.setAttribute("email", u.get().getEmail());
			resp.addHeader("userid", String.valueOf(u.get().getId()));
			resp.addHeader("userrole", u.get().getUserrole());
			resp.addHeader("email", u.get().getEmail());
			return "test";
		}
		return null;
	}
	
//	@RequestMapping(value = "/login", method=RequestMethod.POST)
//	public String login(HttpServletRequest req) {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		
//		System.out.println("IN LOGIN --POST. Attempting to log in user " +
//				username + " with password "+ password);
//		Optional<User> u = userService.login(username, password);
//		if(u == null) {
//			return "redirect:login";
//		} else {
//			HttpSession session = req.getSession();
//			session.setAttribute("user", u);
//			return "redirect:home";
//		}
//	}
	
}
