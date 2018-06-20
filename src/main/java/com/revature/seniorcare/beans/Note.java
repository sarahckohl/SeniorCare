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


@Component
@Entity
@Table(name="Notes")
public class Note {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="note_seq")
	@SequenceGenerator(name="note_seq", sequenceName="note_seq", allocationSize=1)
	@Column(name="Note_ID")
	int id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id", nullable = false)
	Appointment appointment;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	User author;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Calendar created;
	
	@Column(name="text", nullable=false)
	private String text;

	
	
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(int id, Appointment appointment, User author, Calendar created, String text) {
		super();
		this.id = id;
		this.appointment = appointment;
		this.author = author;
		this.created = created;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
	
}
