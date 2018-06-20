package com.revature.seniorcare.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Languages")
public class Language {

	@Id
	@Column(name = "Language_ID")
	@SequenceGenerator(name = "Language_ID_SEQ", sequenceName = "Language_ID_SEQ")
	@GeneratedValue(generator = "Language_ID_SEQ", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "Language", nullable = false)
	private String Language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	
	
}
