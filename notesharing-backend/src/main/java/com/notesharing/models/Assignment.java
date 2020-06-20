package com.notesharing.models;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class Assignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="assignment")
	@SequenceGenerator(name="assignment", sequenceName="assignment_seq", allocationSize=1)
	@Column(name = "assignment_id")
	private int id;
	
	@Column(name = "assignment_student_id")
	private int studentId;
	
	@Column(name = "assignment_instructor_id")
	private int instructorId;
	
	@Column(name = "assignment_type_id")
	private int assignmentTypeId;
	
	@Column(name = "assignment_instrument")
	private String instrument;
	
	
	@Column(name = "assignment_grade")
	private String grade;
	
	@Column(name = "date_assigned")
	private Date dateAssigned;
	
	@Column(name = "date_due")
	private Date dateDue;
	
	@Column(name = "date_submitted")
	private Date dateSubmitted;
	
	@Column(name = "status")
	private String status;


	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Assignment(int id, int studentId, int instructorId, int assignmentTypeId, String instrument, String grade,
			Date dateAssigned, Date dateDue, Date dateSubmitted, String status) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.instructorId = instructorId;
		this.assignmentTypeId = assignmentTypeId;
		this.instrument = instrument;
		this.grade = grade;
		this.dateAssigned = dateAssigned;
		this.dateDue = dateDue;
		this.dateSubmitted = dateSubmitted;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public int getAssignmentTypeId() {
		return assignmentTypeId;
	}

	public void setAssignmentTypeId(int assignmentTypeId) {
		this.assignmentTypeId = assignmentTypeId;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(Date dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public Date getDateDue() {
		return dateDue;
	}

	public void setDateDue(Date dateDue) {
		this.dateDue = dateDue;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + assignmentTypeId;
		result = prime * result + ((dateAssigned == null) ? 0 : dateAssigned.hashCode());
		result = prime * result + ((dateDue == null) ? 0 : dateDue.hashCode());
		result = prime * result + ((dateSubmitted == null) ? 0 : dateSubmitted.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + id;
		result = prime * result + instructorId;
		result = prime * result + ((instrument == null) ? 0 : instrument.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + studentId;
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
		Assignment other = (Assignment) obj;
		if (assignmentTypeId != other.assignmentTypeId)
			return false;
		if (dateAssigned == null) {
			if (other.dateAssigned != null)
				return false;
		} else if (!dateAssigned.equals(other.dateAssigned))
			return false;
		if (dateDue == null) {
			if (other.dateDue != null)
				return false;
		} else if (!dateDue.equals(other.dateDue))
			return false;
		if (dateSubmitted == null) {
			if (other.dateSubmitted != null)
				return false;
		} else if (!dateSubmitted.equals(other.dateSubmitted))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (id != other.id)
			return false;
		if (instructorId != other.instructorId)
			return false;
		if (instrument == null) {
			if (other.instrument != null)
				return false;
		} else if (!instrument.equals(other.instrument))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Assignment [id=" + id + ", studentId=" + studentId + ", instructorId=" + instructorId
				+ ", assignmentTypeId=" + assignmentTypeId + ", instrument=" + instrument + ", grade=" + grade
				+ ", dateAssigned=" + dateAssigned + ", dateDue=" + dateDue + ", dateSubmitted=" + dateSubmitted
				+ ", status=" + status + "]";
	}
	
	
	
	









	
	
	

	

}
