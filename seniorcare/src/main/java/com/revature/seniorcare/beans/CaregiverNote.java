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
@Table(name="CaregiverNotes")
public class CaregiverNote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cg_note_seq")
	@SequenceGenerator(name="cg_note_seq", sequenceName="cg_note_seq", allocationSize=1)
	@Column(name="CaregiverNote_ID")
	int id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caregiver_id", nullable = false)
	Caregiver caregiver;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Calendar created;
	
	@Column(name="text", nullable=false)
	private String text;

	public CaregiverNote() {
		// TODO Auto-generated constructor stub
	}
	
	public CaregiverNote(int id, String text) {
		super();
		this.id = id;
		this.text = text;
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
