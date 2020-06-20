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

import com.notesharing.models.Instrument;
import com.notesharing.services.hibernate.InstrumentService;

@RestController
@RequestMapping(value="/instrument")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://bms-project2.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"})

public class InstrumentController {
	private Logger log = Logger.getLogger(InstrumentController.class);
	
	@Autowired
	private InstrumentService is;
	
	@GetMapping()
	public ResponseEntity<Set<Instrument>> getInstruments() {
		log.trace("getting set of instruments with get");
		log.trace(is.getInstruments());
		return ResponseEntity.ok(is.getInstruments());
	}
	
	@PostMapping
	public ResponseEntity<Integer> addInstrument(@RequestBody Instrument i) {
		log.trace("adding a instrument with post: " + i);
		return ResponseEntity.status(201).body(is.createInstrument(i));
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<Instrument> getInstrument(@PathVariable("id") int id) {
		log.trace("retrieving a instrument with get");
		Instrument i = is.getInstrumentById(id);
		if(i != null) {
			return ResponseEntity.ok(i);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<Instrument> updateInstrument(@PathVariable("id") int id, @RequestBody Instrument i) {
		log.trace("updating a instrument with put");
		// possible error handling?
		is.updateInstrument(i);
		return ResponseEntity.ok(is.getInstrumentById(id));
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteInstrument(@PathVariable("id") int id) {
		log.trace("deleting a instrument with delete");
		is.deleteInstrument(is.getInstrumentById(id));
		return ResponseEntity.noContent().build();
	}
}
