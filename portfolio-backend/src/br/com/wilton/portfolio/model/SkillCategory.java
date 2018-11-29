package br.com.wilton.portfolio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="skill_category")
public class SkillCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSkillCategory;
	
	@Column(length=30)
	private String name; 
	
	@Column(length=200)
	private String image; 
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	public long getIdSkillCategory() {
		return idSkillCategory;
	}

	public void setIdSkillCategory(long idSkillCategory) {
		this.idSkillCategory = idSkillCategory;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
