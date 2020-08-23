package com.notesharing.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "login")
@Inheritance(strategy = InheritanceType.JOINED)


public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "login")
	@SequenceGenerator(name = "login", sequenceName = "login_seq", allocationSize = 1)
	@Column(name = "user_id")
	private int id;
	private String username;
	@Column(name = "user_password")
	private String password;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	@Column(name = "education_level")
	private String level;
	private Date dob;
	private String school_name;
	private String school_state;
	private String school_city;
//	private Course courses[];
	
	


	public Login() {
		super();
	}


	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}





//	public String getSchool() {
//		return school;
//	}
//
//
//	public void setSchool(String school) {
//		this.school = school;
//	}

//
//	public Course[] getCourses() {
//		return courses;
//	}
//
//
//	public void setCourses(Course[] courses) {
//		this.courses = courses;
//	}
//

	public String getSchool_name() {
		return school_name;
	}


	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}


	public String getSchool_state() {
		return school_state;
	}


	public void setSchool_state(String school_state) {
		this.school_state = school_state;
	}


	public String getSchool_city() {
		return school_city;
	}


	public void setSchool_city(String school_city) {
		this.school_city = school_city;
	}


	@Override
	public String toString() {
		return "Login [username=" + username + "]";
	}





}
