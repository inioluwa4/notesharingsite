package com.notesharing.models;

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
//	private String firstname;
//	private String lastname;


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


//	public void setId(int id) {
//		this.id = id;
//	}

//
//	public String getFirstname() {s
//		return firstname;
//	}
//
//
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//
//
//	public String getLastname() {
//		return lastname;
//	}
//
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}


	@Override
	public String toString() {
		return "Login [username=" + username + "]";
	}





}
