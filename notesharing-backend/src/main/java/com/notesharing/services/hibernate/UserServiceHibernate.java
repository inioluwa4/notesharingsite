package com.notesharing.services.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesharing.data.hibernate.UserDAO;
import com.notesharing.models.User;

@Service
public class UserServiceHibernate implements UserService {

	@Autowired
	private UserDAO uDAO;
	
	@Override
	public List<User> getAllUsers(int userId) {
		// get a list of all users in DB.
		List<User> users = new ArrayList<>();
		List<User> userList = new ArrayList<>();
		
		users = uDAO.getUsers();
		
		for (User u : users) {
			if (userId != u.getId())
			{
				userList.add(u);
			}
		}
		
		return userList;
	}

	@Override
	public boolean addNewUser() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
