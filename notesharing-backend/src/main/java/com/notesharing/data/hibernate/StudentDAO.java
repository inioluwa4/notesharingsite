package com.notesharing.data.hibernate;

import java.util.List;

import com.notesharing.models.Course;
import com.notesharing.models.Instructor;
import com.notesharing.models.Student;

public interface StudentDAO {
	
	public Student getStudent(String username, String password);
	public Student getStudentById(int id);
	public List<Instructor> getAllStudents();
	public List<Student> getAllStudentsByCourse(Course course);
	public List<Student> getStudentsByInstrument(int instrumentId);
	
	
	

}
