package com.notesharing.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.notesharing.data.hibernate.InstrumentHibernate;
import com.notesharing.data.hibernate.RequestHibernate;
import com.notesharing.data.hibernate.UniformHibernate;
import com.notesharing.models.IDisplayInv;
import com.notesharing.models.Instrument;
import com.notesharing.models.Inventory;
import com.notesharing.models.Login;
import com.notesharing.models.Request;
import com.notesharing.models.Status;
import com.notesharing.models.Student;
import com.notesharing.models.Uniform;



@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://bms-project2.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"})

public class CheckInCheckOutController {
	private Logger log = Logger.getLogger(CheckInCheckOutController.class);

    @GetMapping(value = "/inventory")
	public ResponseEntity<Set<IDisplayInv>> getUniform(HttpSession session) {
    	Set<IDisplayInv> iDI = new HashSet<IDisplayInv>();
    	UniformHibernate uH = new UniformHibernate();
    	Set<Uniform> u = uH.getUnapprovedUniforms();
    	InstrumentHibernate iH = new InstrumentHibernate();
    	Set<Instrument> i = iH.getUnapprovedInstruments();
    	iDI.addAll(u);
    	iDI.addAll(i);
    	log.trace(session.getId());
		return ResponseEntity.ok(iDI);
	
	}
    @PostMapping(value = "/add/{productId}")
    public ResponseEntity<Request> addRequest(@PathVariable("productId") String itemId, HttpSession session){
    	log.trace("In Post method");
    	log.trace("session id: " + session.getId());
    	 ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    	    HttpServletRequest req = sra.getRequest();
    	    HttpSession s1 =req.getSession();
    	    log.trace("S1 session id: " + s1.getId());
    	//setting fake data to make sure it works while logged in
//    	Student sFake = new Student();
//    	sFake.setId(1);
//    	Login lFake = new Login();
//    	lFake.setStudent(sFake);
//    	session.setAttribute("loggedUser", lFake);
    	//get rid of it when done setting it up with login
    	Login l = (Login) session.getAttribute("loggedUser");
    	log.trace(l);
    	Student s = l.getStudent();
    	Inventory i = new Inventory(Integer.parseInt(itemId));
    	Request r = new Request(null, i, s);
    	Status status = new Status(1);
    	r.setStatus(status);
    	RequestHibernate rH = new RequestHibernate();
    	r.setRequestId(rH.createRequest(r));
		return ResponseEntity.ok(r);
    }
}