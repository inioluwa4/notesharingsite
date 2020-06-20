package com.notesharing.services.hibernate;

import java.util.List;

import com.notesharing.models.User;

public interface UserService {
	public List<User> getAllUsers(int userId);
	public boolean addNewUser();
	

}
