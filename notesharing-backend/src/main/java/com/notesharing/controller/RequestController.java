package com.notesharing.controller;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notesharing.models.Request;
import com.notesharing.services.hibernate.RequestService;

@RestController
@RequestMapping(value="/request")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://bms-project2.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"})

public class RequestController {

	private Logger log = Logger.getLogger(RequestController.class);
	
	@Autowired
	private RequestService rs;
	
	@GetMapping()
	public ResponseEntity<Set<Request>> getBooks() {
		log.trace("getting set of requests with get");
		log.trace(rs.getRequests());
		return ResponseEntity.ok(rs.getRequests());
	}
	
	@PostMapping
	public ResponseEntity<Integer> addRequest(@RequestBody Request r) {
		log.trace("adding a request with post");
		return ResponseEntity.status(201).body(rs.createRequest(r));
	}
	
	@GetMapping(value="{requestId}")
	public ResponseEntity<Request> getBook(@PathVariable("requestId") int id) {
		log.trace("retrieving a request with get");
		Request r = rs.getRequestById(id);
		if(r != null) {
			return ResponseEntity.ok(r);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value="{requestId}")
	public ResponseEntity<Request> updateBook(@PathVariable("requestId") int id, @RequestBody Request r) {
		log.trace("updating a request with put");
		// possible error handling?
		rs.updateRequest(r);
		return ResponseEntity.ok(rs.getRequestById(id));
	}
	
	@DeleteMapping(value="{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int id) {
		log.trace("deleting a request with delete");
		rs.deleteRequest(rs.getRequestById(id));
		return ResponseEntity.noContent().build();
	}
}

	

