package com.revature.seniorcare.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.beans.UserInfo;
import com.revature.seniorcare.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ResponseEntity<UserInfo> login(HttpServletRequest req, HttpServletResponse resp) {
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
			return new ResponseEntity<UserInfo>(new UserInfo(u.get()), HttpStatus.FOUND);
		}
		return null;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public ResponseEntity<UserInfo> register(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String state = req.getParameter("state");
		String city = req.getParameter("city");
		String address = req.getParameter("address");
		String zipcode = req.getParameter("zipcode");
		String phone = req.getParameter("phone");
		String license = req.getParameter("license");
		String userrole = req.getParameter("userrole");

		User newUser = new User( userrole,  username,  password,  firstname,  lastname,  zipcode, state,  city,  address,  license);
		
		System.out.println("IN REGISTER --GET. Attempting to add new user " +
				username + " with password "+ password);
		Optional<User> u = userService.register(newUser);
		
		if(u != null) {
			System.out.println(u.toString());
			HttpSession session = req.getSession();
			session.setAttribute("userid", u.get().getId());
			session.setAttribute("userrole", u.get().getUserrole());
			session.setAttribute("email", u.get().getEmail());
			resp.addHeader("userid", String.valueOf(u.get().getId()));
			resp.addHeader("userrole", u.get().getUserrole());
			resp.addHeader("email", u.get().getEmail());
			return new ResponseEntity<UserInfo>(new UserInfo(u.get()), HttpStatus.CREATED);
		}
		return null;
	}
	
	
}
