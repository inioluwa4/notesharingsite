package com.notesharing.services.hibernate;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.notesharing.data.hibernate.UserDAO;
import com.notesharing.models.Login;



@Service
public class LoginServiceHibernate implements LoginService {

	@Autowired
	private UserDAO uDAO;


	@Override
	public Login getUser(String username, String password) {
		// TODO Auto-generated method stub
		return uDAO.getUser(username, password);
	}


//	@Override
//	public int addUser(Login user) {
//		// TODO Auto-generated method stub
//		return uDAO.addUser(user);
//	}



}
