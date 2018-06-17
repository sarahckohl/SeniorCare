package com.revature.seniorcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.revature.seniorcare.beans.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T, Long> {
	
	public Optional<T> findById(int id);
	public Optional<T> findByEmail(String email);
	public Optional<T> findByfirstName(String firstName);
	public Optional<T> findByLastName(String lastName);
	public Optional<T> findByZipCode(int zipcode);
	public Optional<T> findByCity(String city);
	public Optional<T> findByState(String state);
	public Optional<T> findByStreet(String street);
	//TODO find by open availability/schedule?
}
