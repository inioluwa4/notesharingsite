package com.notesharing.data.hibernate;

import java.util.Set;

import com.notesharing.models.Course;

public interface CourseDAO {
	
	public Integer createCourse(Course course);
	public Course getCourse(Course course);
	public Course getCourseById(Integer id);
	public Set<Course> getCourses();
	public void updateCourse(Course course);
	public void deleteCourse(Course course);
	

}
