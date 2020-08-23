package com.notesharing.controller;

import javax.servlet.http.HttpSession;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notesharing.models.Login;

import com.notesharing.services.hibernate.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class LoginController {

	private Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService logServ;

	@GetMapping(value = "/login")
	public ResponseEntity<Login> login(HttpSession session) {
		Login loggedUser = (Login) session.getAttribute("loggedUser");
		log.trace("Logged User"+loggedUser);
		if (loggedUser == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(loggedUser);
	}
//
	@PostMapping(value = "/login")
	public ResponseEntity<Login> postLogin(String username, String password, HttpSession session) {
		Login loggedIn = logServ.getUser(username, password);


		log.trace("Attempting to log in as User " + username + ", " + password);

		if (loggedIn == null) {
			log.trace("Cannot login null user");
			return ResponseEntity.notFound().build();
		} else {
			// Check if Person is a user
			log.trace("Logging in");
			Login loggedUser = new Login(username,password);

			session.setAttribute("loggedUser", loggedUser);
			return ResponseEntity.ok(loggedUser);

		}

	}
	@PostMapping(value = "/register")
	public ResponseEntity<Login> register(@RequestBody Login user, HttpSession session) {
		int i = logServ.addUser(user);
		session.setAttribute("loggedUser", user);
		log.trace(user);

		if (i > 0){
			log.trace("User Saved to db " + user);
			return ResponseEntity.ok(user);
		}
		else {
			log.trace("User not saved to db " + user);
			return ResponseEntity.notFound().build();
		}
		
		

	}

	@DeleteMapping(value = "/login")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}

}
