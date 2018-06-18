package com.revature.seniorcare.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.seniorcare.beans.Note;
import com.revature.seniorcare.beans.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

	public Optional<User> findById(int id);
	public Optional<User> findByEmail(String email);
	public Optional<User> findByfirstName(String firstName);
	public Optional<User> findByLastName(String lastName);
	public Optional<User> findByZipCode(int zipcode);
	public Optional<User> findByCity(String city);
	public Optional<User> findByState(String state);
	public Optional<User> findByStreet(String street);
	
}
