package com.notesharing.services.hibernate;

import com.notesharing.models.Login;

public interface LoginService {
	public Login getUser (String username, String password);
	
	

}
