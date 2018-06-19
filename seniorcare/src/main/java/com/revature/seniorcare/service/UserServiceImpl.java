package com.revature.seniorcare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.Appointment;
import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.repository.UserRepository;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findById(int id) {
		return Optional.ofNullable(userRepo.findOne(id));
	}

	@Override
	public Optional<User> findByFirstName(String name) {
		return userRepo.findByfirstName(name);
	}

	@Override
	public Appointment addAppointment(User u, Appointment a) {
		// TODO Auto-generated method stub
		return a;
	}

	@Override
	public Optional<User> login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User add(User newuser) {
		User u = userRepo.save(newuser);
		return u;
	}

}
