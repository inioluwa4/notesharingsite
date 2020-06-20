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

import com.notesharing.models.Uniform;
import com.notesharing.services.hibernate.UniformService;

@RestController
@RequestMapping(value="/uniform")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://bms-project2.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"})

public class UniformController {
private Logger log = Logger.getLogger(UniformController.class);
	
	@Autowired
	private UniformService us;
	
	@GetMapping()
	public ResponseEntity<Set<Uniform>> getUniforms() {
		log.trace("getting set of uniforms with get");
		log.trace(us.getUniforms());
		return ResponseEntity.ok(us.getUniforms());
	}
	
	@PostMapping
	public ResponseEntity<Integer> addUniform(@RequestBody Uniform u) {
		log.trace("adding a uniform with post");
		return ResponseEntity.status(201).body(us.createUniform(u));
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Uniform> getUniform(@PathVariable("id") int id) {
		log.trace("retrieving a uniform with get");
		Uniform u = us.getUniformById(id);
		if(u != null) {
			return ResponseEntity.ok(u);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<Uniform> updateUniform(@PathVariable("id") int id, @RequestBody Uniform u) {
		log.trace("updating a uniform with put");
		// possible error handling?
		us.updateUniform(u);
		return ResponseEntity.ok(us.getUniformById(id));
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteUniform(@PathVariable("id") int id) {
		log.trace("deleting a uniform with delete");
		us.deleteUniform(us.getUniformById(id));
		return ResponseEntity.noContent().build();
	}
}
