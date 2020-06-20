package com.notesharing.models;

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
@Table(name="students")
@PrimaryKeyJoinColumn(name="student_id")

public class Student extends User {
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="student_instrument_type_id")
	private InstrumentType instrumentType;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="student_grade_level_id")
	private GradeLevel gradeLevel;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="student_course_id")
	private Course course;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="student_uniform_type_id")
	private UniformType uniformType;

	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Student(int id, String username, String password) {
		super(id, username, password);
		// TODO Auto-generated constructor stub
	}



	public Student(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}



	public Student(InstrumentType instrumentType, GradeLevel gradeLevel, Course course, UniformType uniformType) {
		super();
		this.instrumentType = instrumentType;
		this.gradeLevel = gradeLevel;
		this.course = course;
		this.uniformType = uniformType;
	}



	public InstrumentType getInstrumentType() {
		return instrumentType;
	}



	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}



	public GradeLevel getGradeLevel() {
		return gradeLevel;
	}



	public void setGradeLevel(GradeLevel gradeLevel) {
		this.gradeLevel = gradeLevel;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public UniformType getUniformType() {
		return uniformType;
	}



	public void setUniformType(UniformType uniformType) {
		this.uniformType = uniformType;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((gradeLevel == null) ? 0 : gradeLevel.hashCode());
		result = prime * result + ((instrumentType == null) ? 0 : instrumentType.hashCode());
		result = prime * result + ((uniformType == null) ? 0 : uniformType.hashCode());
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
		Student other = (Student) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (gradeLevel == null) {
			if (other.gradeLevel != null)
				return false;
		} else if (!gradeLevel.equals(other.gradeLevel))
			return false;
		if (instrumentType == null) {
			if (other.instrumentType != null)
				return false;
		} else if (!instrumentType.equals(other.instrumentType))
			return false;
		if (uniformType == null) {
			if (other.uniformType != null)
				return false;
		} else if (!uniformType.equals(other.uniformType))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Student [instrumentType=" + instrumentType + ", gradeLevel=" + gradeLevel + ", course=" + course
				+ ", uniformType=" + uniformType + "]";
	}




}
	
	
	

	
	

