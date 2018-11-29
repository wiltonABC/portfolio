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

@Entity(name="skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSkill; 
	
	@ManyToOne
	private SkillCategory skillCategory; 
	
	@Column(length=30)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	public long getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(long idSkill) {
		this.idSkill = idSkill;
	}

	public SkillCategory getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(SkillCategory skillCategory) {
		this.skillCategory = skillCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
}
