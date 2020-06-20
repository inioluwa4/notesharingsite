package com.notesharing.data.hibernate;

import java.util.Set;

import com.notesharing.models.GradeLevel;

public interface GradeLevelDAO { 
	
	public Integer createGradeLevel(GradeLevel gradeLevel);
	public GradeLevel getGradeLevel(GradeLevel gradeLevel);
	public GradeLevel getGradeLevelById(Integer id);
	public Set<GradeLevel> getGradeLevels();
	public void updateGradeLevel(GradeLevel gradeLevel);
	public void deleteGradeLevel(GradeLevel gradeLevel);
	

}
