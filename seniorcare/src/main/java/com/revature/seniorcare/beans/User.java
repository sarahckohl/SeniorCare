package com.revature.seniorcare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Inheritance
@Table(name="USERS")
public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(name="PNT_ID_SEQ_GEN", sequenceName="PNT_ID_SEQ")	
	@GeneratedValue(generator="PNT_ID_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	int id;
	
	
	@Column(name="username", nullable=false)
	private String username;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="firstName", nullable=false)
	private String firstName;
	
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;
	
	@Column(name="zipCode", nullable=false)
	private int zipCode;
	
	@Column(name="state", nullable=false)
	private String state;
	
	@Column(name="city", nullable=false)
	private String city;
	
	@Column(name="street", nullable=false)
	private String street;
	
	@Autowired
	private Schedule schedule;
	
	public User(int id, String username, String email, String firstName, String lastName, int zipCode, String state,
			String city, String street) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.state = state;
		this.city = city;
		this.street = street;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public Schedule getSchedule(Schedule schedule) {
		return this.schedule;
	}

}
