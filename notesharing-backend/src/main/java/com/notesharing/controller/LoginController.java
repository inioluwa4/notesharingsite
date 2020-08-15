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
@CrossOrigin(origins = "*")

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
	public ResponseEntity<Login> postLogin(String user, String pass, HttpSession session) {
		Login loggedIn = logServ.getUser(user, pass);


		log.trace("Attempting to log in as User " + user + ", " + pass);

		if (loggedIn == null) {
			log.trace("Cannot login null user");
			return ResponseEntity.notFound().build();
		} else {
			// Check if Person is a user
			log.trace("Logging in");
			Login loggedUser = new Login(loggedIn.getUsername(), loggedIn.getPassword());

			session.setAttribute("loggedUser", loggedUser);
			return ResponseEntity.ok(loggedUser);

		}

	}
	@PostMapping(value = "/register")
	public ResponseEntity<Login> register(Login user) {
		int i = logServ.addUser(user);

		if (i > 0){
			log.trace("User Saved to db " + user.getFirstname());
			return ResponseEntity.ok(user);
		}
		else {
			log.trace("User not saved to db " + user.getFirstname());
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping(value = "/login")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}

}
