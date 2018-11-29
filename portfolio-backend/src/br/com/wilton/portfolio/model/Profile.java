package br.com.wilton.portfolio.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.wilton.portfolio.annotations.ProfileFullView;


@Entity(name="profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProfile;
	
	@Column(length=80)
	private String name;
 
	@Column(length=12)
	private String shortName;
	
	@Column(length=40)
	private String mainActivity;
	
	@Column(length=1000)
	private String about;
	
	@Column(length=200)
	private String image;
	
	@Column(length=60, unique=true, nullable=false)
	private String email;
	
	@Column(length=50)
	private String address;
	
	@Column(length=50)
	private String address2;

	@Column(length=50)
	private String city;

	@Column(length=30)
	private String stateProvince;
	
	@Column(length=20)
	private String postalCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;
	
	@ProfileFullView
	@ManyToMany
	private Set<Skill> skills;
	
	@ProfileFullView
	@OneToMany(mappedBy="profile")
	@JsonManagedReference //Used to define the part of a bidirectional relationship that will be serialized
	private List<Feedback> feedbacks;
	

	@ProfileFullView
	@OneToMany(mappedBy="profile")
	@JsonManagedReference
	private List<Message> messages;
	
	@ProfileFullView
	@OneToMany(mappedBy="profile")
	@JsonManagedReference
	private List<WorkDone> workDone;

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(String mainActivity) {
		this.mainActivity = mainActivity;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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

	public long getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(long idProfile) {
		this.idProfile = idProfile;
	}
	

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public List<WorkDone> getWorkDone() {
		return workDone;
	}
}
