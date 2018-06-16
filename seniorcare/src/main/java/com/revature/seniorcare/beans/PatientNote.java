package com.revature.seniorcare.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

/**
 * A note is simply a description of a patients medical needs.
 * @author Sarah
 *
 */

@Component
@Entity
@Table(name="PatientNotes")
public class PatientNote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="p_note_seq")
	@SequenceGenerator(name="p_note_seq", sequenceName="p_note_seq", allocationSize=1)
	@Column(name="PatientNote_ID")
	int id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
	Patient patient;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Calendar created;
	
	@Column(name="text", nullable=false)
	private String text;

	
	public PatientNote(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public PatientNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
}
