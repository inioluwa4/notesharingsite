package com.notesharing.services.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.notesharing.data.hibernate.CourseDAO;
import com.notesharing.data.hibernate.UserDAO;
import com.notesharing.models.Course;
import com.notesharing.models.Login;



@Service
public class CourseServiceHibernate implements CourseService {

	@Autowired
	private CourseDAO cDAO;

	@Override
	public List<Course> getCoursesByUser(Login user) {
		// TODO Auto-generated method stub
		return cDAO.getCoursesByUser(user);
	}

	@Override
	public Boolean addCourse(Course course){
		// TODO Auto-generated method stub
		return cDAO.addCourse(course);
	}
	
	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		cDAO.deleteCourse(course);		
	}
	
	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return cDAO.updateCourse(course);
	}






}
