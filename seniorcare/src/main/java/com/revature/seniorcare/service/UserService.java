package com.revature.seniorcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.seniorcare.beans.User;

@Service
public interface UserService {
	
	List<User> getAll();
	Optional<User> findById(int id);
	Optional<User> findByFirstName(String name);
	Optional<User> login(String username, String password);
}
