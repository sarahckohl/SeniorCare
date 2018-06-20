package com.revature.seniorcare.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Preferences")
public class Preference {

	@Id
	@Column(name="Preference_ID")
	@SequenceGenerator(name="Preference_ID_SEQ", sequenceName="Preference_ID_SEQ")	
	@GeneratedValue(generator="Preference_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;

	@Column(name="Preference")
	private String Preference;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language")
	private Language language;

	public Preference() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Preference(int id, String preference, Language language) {
		super();
		this.id = id;
		Preference = preference;
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreference() {
		return Preference;
	}

	public void setPreference(String preference) {
		Preference = preference;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	
	
}
