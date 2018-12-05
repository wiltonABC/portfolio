package br.com.wilton.portfolio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFeedback; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private Profile profile; 
	
	@Column(length=30)
	private String author; 
	
	@Column(length=30)
	private String company;
	
	@Column(length=60)
	private String text;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	public long getIdFeedback() {
		return idFeedback;
	}

	public void setIdFeedback(long idFeedback) {
		this.idFeedback = idFeedback;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	

}
