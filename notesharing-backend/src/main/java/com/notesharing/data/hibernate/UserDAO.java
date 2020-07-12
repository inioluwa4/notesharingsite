package com.notesharing.data.hibernate;

import java.util.List;

import com.notesharing.models.Login;

public interface UserDAO {
	
	public Login getUser(String username, String password);

	
	

}
