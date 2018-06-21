package com.revature.seniorcare.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Inheritance
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "USR_ID_SEQ", sequenceName = "USR_ID_SEQ")
	@GeneratedValue(generator = "USR_ID_SEQ", strategy = GenerationType.SEQUENCE)
	int id;

	@Column(name = "userrole", nullable = false)
	private String userrole;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "zipCode", nullable = false)
	private String zipCode;

	@Column(name = "state", nullable = false)
	private String state;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "street", nullable = false)
	private String street;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "User_APPOINTMENTS", joinColumns = @JoinColumn(name = "user_ID"), inverseJoinColumns = @JoinColumn(name = "appointment_ID"))
	private Set<Appointment> schedule;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "PATIENTS_PREFERRED_Caregivers", joinColumns = @JoinColumn(name = "patient_ID"), inverseJoinColumns = @JoinColumn(name = "caregiver_ID"))
	private Set<User> preferredCaregivers;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "PATIENTS_PREFERENCES", joinColumns = @JoinColumn(name = "patient_ID"), inverseJoinColumns = @JoinColumn(name = "preference_ID"))
	private Set<Preference> preferences;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name = "Caregivers_AvailabilityBlocks", joinColumns = @JoinColumn(name = "caregiver_ID"), inverseJoinColumns = @JoinColumn(name = "availabilityblock_ID"))
	private Set<AvailabilityBlock> availability;

	@Column(name = "licensenumber", unique = true)
	String licenseNumber;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String userrole, String email, String password, String firstName, String lastName, String zipCode,
			String state, String city, String street, String licenseNumber) {
		super();
		this.id = id;
		this.userrole = userrole;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.state = state;
		this.city = city;
		this.street = street;
		this.licenseNumber = licenseNumber;
	}

	public User(String userrole, String email, String password, String firstName, String lastName, String zipCode,
			String state, String city, String street, String licenseNumber) {
		this.userrole = userrole;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.state = state;
		this.city = city;
		this.street = street;
		this.licenseNumber = licenseNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
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

	public Set<Appointment> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Appointment> schedule) {
		this.schedule = schedule;
	}

	public Set<User> getPreferredCaregivers() {
		return preferredCaregivers;
	}

	public void setPreferredCaregivers(Set<User> preferredCaregivers) {
		this.preferredCaregivers = preferredCaregivers;
	}

	public Set<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<Preference> preferences) {
		this.preferences = preferences;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Set<AvailabilityBlock> getAvailability() {
		return availability;
	}

	public void setAvailability(Set<AvailabilityBlock> availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userrole=" + userrole + ", email=" + email + "";
	}

}
