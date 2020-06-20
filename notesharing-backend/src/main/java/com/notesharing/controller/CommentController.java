package com.notesharing.controller;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notesharing.models.Comment;
import com.notesharing.services.hibernate.CommentService;

@RestController
@RequestMapping(value="/contact")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://bms-project2.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"})

public class CommentController {
	
	private Logger log = Logger.getLogger(UniformController.class);
	
	@Autowired
	private CommentService cs;
	
	@GetMapping()
	public ResponseEntity<Set<Comment>> getAllComments() {
		log.trace("getting set of comments with get");
		log.trace(cs.getAllComments());
		return ResponseEntity.ok(cs.getAllComments());
		
	}
	
	@PostMapping
	public ResponseEntity<Integer> addComment(@RequestBody Comment c) {
		log.trace("Adding a comment with post");
		return ResponseEntity.status(201).body(cs.addComment(c));
		
	}
}
