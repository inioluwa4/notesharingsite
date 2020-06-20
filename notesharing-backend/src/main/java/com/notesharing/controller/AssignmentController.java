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
import com.notesharing.models.Course;
import com.notesharing.models.Login;
import com.notesharing.services.hibernate.AssignmentService;



@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://bms-project2.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"})

public class AssignmentController {
	private Logger log = Logger.getLogger(AssignmentHibernate.class);

	

		@Autowired
		private AssignmentService assgnServ;
		
		@GetMapping(value="/assignments")
		public ResponseEntity<List<Assignment>> getAllAssignments(HttpSession session) {
			Login loggedUser = (Login) session.getAttribute("loggedUser");
			if(loggedUser.getInstructor() != null) {
			
				int instructorId = loggedUser.getInstructor().getId();
				
				return ResponseEntity.ok(assgnServ.getAllAssignments(instructorId,0));
			}
			
			else if(loggedUser.getStudent() != null) {
				
				int studentId = loggedUser.getStudent().getId();
				
				return ResponseEntity.ok(assgnServ.getAllAssignments(0,studentId));
			}
			else {
				return ResponseEntity.notFound().build();

			}
			
		}
		
		@PostMapping(value="/assignments")
		public ResponseEntity<Assignment> addAssignment(@RequestBody Assignment a, HttpSession session) {
			Login loggedUser = (Login) session.getAttribute("loggedUser");
			
			log.trace("LoggedUser "+loggedUser);
			log.trace("CourseId " + loggedUser.getInstructor().getCourse().getCourseId());
			log.trace("Instrument " + a.getInstrument());

			Course course = loggedUser.getInstructor().getCourse();
			
			
			String instrument = "";
			if (a.getInstrument() != null) {
				instrument = a.getInstrument();

			}
			
			a.setInstructorId(loggedUser.getInstructor().getId());
			log.trace("Adding Assignment "+ a);

		

			
			return ResponseEntity.status(201).body(assgnServ.createAssignment(a, course, instrument));
		}
		
		@PutMapping(value="/assignments/{id}/{grade}")
		public ResponseEntity<Boolean> getAssignment(@PathVariable("id") int id, @PathVariable("grade") String grade, HttpSession session) {
			Login loggedUser = (Login) session.getAttribute("loggedUser");
			if(loggedUser.getInstructor() != null) {
			
				Boolean a = assgnServ.gradeAssignment(id, grade);
				if(a != null) {
					return ResponseEntity.ok(a);
				}
			}
			
			else if(loggedUser.getStudent() != null) {
				
				Boolean a = assgnServ.turnInAssignment(id);
				if(a != null) {
					return ResponseEntity.ok(a);
				}
			}
			
			return ResponseEntity.notFound().build();
		}
//		
//		@PutMapping(value="{id}")
//		public ResponseEntity<Assignment> updateBook(@PathVariable("bookId") int id, @RequestBody Book b) {
//			// possible error handling?
//			bs.updateBook(b);
//			return ResponseEntity.ok(bs.getBookById(id));
//		}
//		



}
