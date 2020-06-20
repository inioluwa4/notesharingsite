package com.notesharing.services.hibernate;

import com.notesharing.models.Instructor;
import com.notesharing.models.Student;
import com.notesharing.models.User;

public interface LoginService {
	public Instructor loginAsInstructor(String user, String pass);
	public Student loginAsStudent(String user, String pass);
	public User getUser (String username, String password);
	public Instructor getById (int id);
	

}
