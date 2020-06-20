package com.notesharing.data.hibernate;

import org.hibernate.query.Query;


import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.notesharing.controller.LoginController;
import com.notesharing.models.Instructor;
import com.notesharing.models.User;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;



@Repository

public class InstructorHibernate implements InstructorDAO{
	private Logger log = Logger.getLogger(InstructorHibernate.class);

	private static HibernateUtil hu = HibernateUtil.getInstance();





	@Override
	public Instructor getInstructor (String user, String pass) {
		log.trace("Getting Instructor "+user+", "+pass);
		Session s = hu.getSession();
		Query<Instructor> q = s.createQuery("FROM Instructor where username =:username and password=:password", Instructor.class);
		q.setParameter("username", user);
		q.setParameter("password",  pass);
		Instructor a = q.uniqueResult();
		s.close();
		return a;
	}


	@Override
	public Instructor getInstructorById(int id) {
		log.trace("Getting Instructor by Id "+id);
		Session s = hu.getSession();
		Instructor ret = s.get(Instructor.class, id);
		s.close();
		return ret;
	}

	@Override
	public List<Instructor> getAllInstructors() {
		log.trace("Getting all Instructors");

			Session s = hu.getSession();
			String query = "FROM instructors";
			Query<Instructor> q = s.createQuery(query, Instructor.class);
			List<Instructor> instrList = q.getResultList();
			s.close();
			return instrList;

	}

}
