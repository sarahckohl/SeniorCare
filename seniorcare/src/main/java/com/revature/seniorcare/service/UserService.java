package com.revature.seniorcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.revature.seniorcare.beans.User;

@Component
public interface UserService {
	
	List<User> getAll();
	Optional<User> findById(int id);
	Optional<User> findByFirstName(String name);


}
