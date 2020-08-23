package com.notesharing.controller;

import java.util.List;

import javax.servlet.http.HttpSession;





import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notesharing.models.Course;
import com.notesharing.models.Login;
import com.notesharing.services.hibernate.CourseService;
import com.notesharing.services.hibernate.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CoursesController {

	private Logger log = Logger.getLogger(CoursesController.class);

	@Autowired
	private CourseService courseServ;

	@GetMapping(value = "/courses/all")
	public ResponseEntity<List<Course>> login(HttpSession session) {
		Login loggedUser = (Login) session.getAttribute("loggedUser");
		log.trace("Logged User"+loggedUser);
		if (loggedUser != null) {
		courseServ.getCoursesByUser(loggedUser);
		return ResponseEntity.ok(courseServ.getCoursesByUser(loggedUser));
		}
		else {
			return ResponseEntity.status(401).build();
		}
	}
//

	@PostMapping(value = "/courses/add")
	public ResponseEntity<Boolean> register(@RequestBody Course[] courses, HttpSession session) {
	
		try {
			
			for(Course c : courses){
				
				Login loggedUser = (Login) session.getAttribute("loggedUser");
				c.setCourse_user(loggedUser);
				log.trace("Adding Course - " + c);
				courseServ.addCourse(c);
				
			}
			return ResponseEntity.ok(true);
	//
			
		}
		catch (Exception e) {
			log.trace("Error while saving courses");
			return ResponseEntity.notFound().build();
			
		}

	}

	@DeleteMapping(value = "/courses/remove")
	public ResponseEntity<Void> logout(@RequestBody Course course) {
		courseServ.deleteCourse(course);
		
		return ResponseEntity.noContent().build();
	}

}
