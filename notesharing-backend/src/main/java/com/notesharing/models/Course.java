package com.notesharing.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name="course")
@PrimaryKeyJoinColumn(name="user_id")

public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course")
	@SequenceGenerator(name = "course", sequenceName = "course_seq", allocationSize = 1)
	@Column(name = "course_id")
	private int id;
	private String title;
	private String Instructor;
	@Column(name = "course_days")
	private String days;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="course_user_id")
	private Login course_user;
	@Column(name="course_start")
	private Timestamp start;

	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}




	public String getInstructor() {
		return Instructor;
	}



	public void setInstructor(String instructor) {
		Instructor = instructor;
	}



	public String getDays() {
		return days;
	}



	public void setDays(String days) {
		this.days = days;
	}



	public Timestamp getStart() {
		return start;
	}



	public void setStart(Timestamp start) {
		this.start = start;
	}



	public String getCourse_days() {
		return days;
	}



	public void setCourse_days(String course_days) {
		this.days = course_days;
	}



	public Login getCourse_user() {
		return course_user;
	}



	public void setCourse_user(Login course_user) {
		this.course_user = course_user;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Instructor == null) ? 0 : Instructor.hashCode());
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((course_user == null) ? 0 : course_user.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (Instructor == null) {
			if (other.Instructor != null)
				return false;
		} else if (!Instructor.equals(other.Instructor))
			return false;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		if (course_user == null) {
			if (other.course_user != null)
				return false;
		} else if (!course_user.equals(other.course_user))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", Instructor=" + Instructor + ", course_days=" + days
				+ ", course_user=" + course_user + "]";
	}




}


	

