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

@Entity(name="work_done")
public class WorkDone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idWorkDone;
	
	@ManyToOne
	@JsonBackReference
	private Profile profile; 
	
	@Column(length=40)
	private String name; 
	
	@Column(length=200)
	private String image; 
	
	@Column(length=800)
	private String description; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;

	public long getIdWorkDone() {
		return idWorkDone;
	}

	public void setIdWorkDone(long idWorkDone) {
		this.idWorkDone = idWorkDone;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
	

}
