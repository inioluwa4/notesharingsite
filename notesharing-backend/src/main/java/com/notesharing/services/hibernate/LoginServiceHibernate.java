package com.notesharing.services.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesharing.data.hibernate.InstructorDAO;
import com.notesharing.data.hibernate.StudentDAO;
import com.notesharing.data.hibernate.UserDAO;
import com.notesharing.models.Instructor;
import com.notesharing.models.Student;
import com.notesharing.models.User;


@Service
public class LoginServiceHibernate implements LoginService {

	@Autowired
	private UserDAO uDAO;
	
	@Autowired
	private InstructorDAO instrDAO;
	@Autowired
	private StudentDAO stuDAO;
	
	
	@Override
	public Instructor loginAsInstructor(String user, String pass) {
		// TODO Auto-generated method stub
		return instrDAO.getInstructor(user, pass) ;
	}

	@Override
	public Student loginAsStudent(String user, String pass) {
		// TODO Auto-generated method stub
		return stuDAO.getStudent(user, pass);
	}

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		return uDAO.getUser(username, password);
	}

	@Override
	public Instructor getById(int id) {
		// TODO Auto-generated method stub
		return instrDAO.getInstructorById(3);
	}

}
