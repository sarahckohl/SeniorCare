package com.revature.seniorcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.seniorcare.beans.User;
import com.revature.seniorcare.repository.UserRepository;

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
		return Optional.ofNullable(userRepo.findOne((long)id));
	}

	@Override
	public Optional<User> findByFirstName(String name) {
		return userRepo.findByfirstName(name);
	}

}
