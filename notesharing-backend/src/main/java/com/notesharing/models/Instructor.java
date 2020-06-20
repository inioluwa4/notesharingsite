package com.notesharing.models;

import javax.persistence.CascadeType;
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
@Table(name="instructors")
@PrimaryKeyJoinColumn(name="instructor_id")

public class Instructor extends User {
		
	
	@OneToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)	
	@JoinColumn(name= "instructor_course_id")
	private Course course;



	






	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Instructor(int id) {
		super(id);
	}
	public Instructor(int id, String username, String password) {
		super(id, username, password);
	}


	public Course getCourse() {
		return course;
	}



	public void setCourseId(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Instructor [course=" + course + ", getId()=" + getId() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getFirstname()=" + getFirstname() + ", getLastname()="
				+ getLastname() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
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
		Instructor other = (Instructor) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		return true;
	}













	
	
	

	
	
}
