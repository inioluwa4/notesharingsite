package com.notesharing.data.hibernate;

import java.util.List;

import com.notesharing.models.Assignment;


public interface AssignmentDAO {
	
	public Assignment createAssignment(Assignment a);
	public List<Assignment> getAllAssignments(int instructorId, int studentId);
	public Assignment getAssignmentById(int id);
	public boolean gradeAssignment(int id, String grade);
	public boolean updateAssignment(Assignment a);


}
