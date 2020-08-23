package com.notesharing.services.hibernate;

import java.util.List;

import com.notesharing.models.Course;
import com.notesharing.models.Login;

public interface CourseService {
	public List<Course> getCoursesByUser (Login user);
	public Boolean addCourse (Course course);
	public void deleteCourse (Course course);
	public Course updateCourse (Course course);
	
	

}
