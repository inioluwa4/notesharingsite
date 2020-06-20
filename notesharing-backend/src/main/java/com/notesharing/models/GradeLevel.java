package com.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "grade_levels")

@Component
public class GradeLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_levels")
	@SequenceGenerator(name = "grade_levels", sequenceName = "grade_levels_seq", allocationSize = 1)
	@Column(name = "grade_level_id")
	private Integer gradeLevelId;
	@Column(name = "grade_level_name")
	private String gradeLevelName;
	
	//construc.
	public GradeLevel() {
		super();
	
	}
	public GradeLevel(Integer gradeLevelId) {
		super();
		this.gradeLevelId = gradeLevelId;
	}
	public GradeLevel(Integer gradeLevelId, String gradeLevelName) {
		super();
		this.gradeLevelId = gradeLevelId;
		this.gradeLevelName = gradeLevelName;
	}
	/**
	 * @return the gradeLevelId
	 */
	public Integer getGradeLevelId() {
		return gradeLevelId;
	}
	/**
	 * @param gradeLevelId the gradeLevelId to set
	 */
	public void setGradeLevelId(Integer gradeLevelId) {
		this.gradeLevelId = gradeLevelId;
	}
	/**
	 * @return the gradeLevelName
	 */
	public String getGradeLevelName() {
		return gradeLevelName;
	}
	/**
	 * @param gradeLevelName the gradeLevelName to set
	 */
	public void setGradeLevelName(String gradeLevelName) {
		this.gradeLevelName = gradeLevelName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gradeLevelId == null) ? 0 : gradeLevelId.hashCode());
		result = prime * result + ((gradeLevelName == null) ? 0 : gradeLevelName.hashCode());
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
		GradeLevel other = (GradeLevel) obj;
		if (gradeLevelId == null) {
			if (other.gradeLevelId != null)
				return false;
		} else if (!gradeLevelId.equals(other.gradeLevelId))
			return false;
		if (gradeLevelName == null) {
			if (other.gradeLevelName != null)
				return false;
		} else if (!gradeLevelName.equals(other.gradeLevelName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GradeLevel [gradeLevelId=" + gradeLevelId + ", gradeLevelName=" + gradeLevelName + "]";
	}

}
