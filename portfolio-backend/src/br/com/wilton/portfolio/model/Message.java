package br.com.wilton.portfolio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMessage;
	
	@ManyToOne()
	@JsonBackReference //Used to define the part of a bidirectional relationship that will not be serialized
	private Profile profile;
	
	@Column(length = 40)
	private String name;
	
	@Column(length = 60)
	private String email; 
	
	@Column(length = 50)
	private String subject;
	
	@Column(length = 300)
	private String message;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	public long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(long idMessage) {
		this.idMessage = idMessage;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
}
