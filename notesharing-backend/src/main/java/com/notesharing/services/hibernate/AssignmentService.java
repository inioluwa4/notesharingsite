package com.notesharing.services.hibernate;

import java.util.List;

import com.notesharing.models.Assignment;
import com.notesharing.models.Course;

public interface AssignmentService {
	public Assignment createAssignment(Assignment a, Course course, String instrument);
	public List<Assignment> getAllAssignments(int instructorId, int studentId);
	public Assignment getAssignmentById(int id);
	public boolean gradeAssignment(int id, String grade);
	public boolean turnInAssignment(int id);


}
