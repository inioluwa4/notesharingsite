package com.notesharing.controller;


import java.util.List;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notesharing.data.hibernate.AssignmentHibernate;
import com.notesharing.models.Assignment;
import com.notesharing.models.Chatter;
import com.notesharing.models.Course;
import com.notesharing.models.Login;
import com.notesharing.services.hibernate.AssignmentService;
import com.notesharing.services.hibernate.ChatterService;



@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://bms-project2.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"})


public class ChatterController {
	private Logger log = Logger.getLogger(ChatterController.class);

	

		@Autowired
		private ChatterService cServ;
		
		@GetMapping(value="/chat")
		public ResponseEntity<List<Chatter>> getAllUnreadMessages(HttpSession session) {
			Login loggedUser = (Login) session.getAttribute("loggedUser");
			if(loggedUser.getInstructor() != null) {
			
				int instructorId = loggedUser.getInstructor().getId();
				
				return ResponseEntity.ok(cServ.getAllUnreadMessages(instructorId));
			}
			
			else if(loggedUser.getStudent() != null) {
				
				int studentId = loggedUser.getStudent().getId();
				
				return ResponseEntity.ok(cServ.getAllUnreadMessages(studentId));
			}
			else {
				return ResponseEntity.notFound().build();

			}
			
		}
		
		@PostMapping(value="/chat")
		public ResponseEntity<Chatter> addAssignment(@RequestBody Chatter c, HttpSession session) {
			Login loggedUser = (Login) session.getAttribute("loggedUser");
			
			log.trace("LoggedUser "+loggedUser);
			
			if(loggedUser.getInstructor() != null) {
				c.setSender(loggedUser.getInstructor().getId());
			}
			
			if(loggedUser.getStudent() != null) {
				c.setSender(loggedUser.getStudent().getId());
			}
			
			
			log.trace("Adding Message "+ c);

		

			
			return ResponseEntity.status(201).body(cServ.createMessage(c));
		}
		
		@PutMapping(value="/chat")
		public ResponseEntity<Chatter> getAssignment(@RequestBody Chatter c) {
			
			return ResponseEntity.ok(cServ.updateMessage(c));
		}

//		



}
