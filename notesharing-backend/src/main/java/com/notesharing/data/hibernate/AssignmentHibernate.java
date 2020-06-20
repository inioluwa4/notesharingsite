package com.notesharing.data.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.controller.LoginController;
import com.notesharing.models.Assignment;
import com.notesharing.models.Instructor;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;

@Repository
public class AssignmentHibernate implements AssignmentDAO {
	private static HibernateUtil hu = HibernateUtil.getInstance();

	private Logger log = Logger.getLogger(AssignmentHibernate.class);


	@Override
	public Assignment createAssignment(Assignment a) {
		// Add assignment to the database.
		Integer id = null;
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			id = (Integer) s.save(a);
			t.commit();
		} catch(HibernateException e) {
			if (t != null)
				t.rollback();
			LogUtil.logException(e, AssignmentHibernate.class);
			return null;

		} finally {
			s.close();
		}
		return a;

		
	}

	@Override
	public List<Assignment> getAllAssignments(int instructorId, int studentId) {
		// Get all assignments by Id.
		if (instructorId > 0)
		{
			log.trace("Getting all Assignments for instructor");
	
			Session s = hu.getSession();
			Query<Assignment> q = s.createQuery("FROM Assignment where instructorId =:id", Assignment.class);
			q.setParameter("id", instructorId);
			List<Assignment> assignmentList = q.getResultList();
			s.close();
			return assignmentList;
		}
		else if (studentId > 0){
			log.trace("Getting all Assignments for student");
			
			Session s = hu.getSession();
			Query<Assignment> q = s.createQuery("FROM Assignment where studentId =:id", Assignment.class);
			q.setParameter("id", studentId);
			List<Assignment> assignmentList = q.getResultList();
			s.close();
			return assignmentList;
			
		}
		return null;
		
	}

	@Override
	public Assignment getAssignmentById(int id) {
		// Get assignment by assignment id.
		log.trace("Getting Assignment by Id "+id);
		Session s = hu.getSession();
		Assignment ret = s.get(Assignment.class, id);
		s.close();
		return ret;
	}

	@Override
	public boolean gradeAssignment(int id, String grade) {
		log.trace("Updating grade on assignment id "+id);
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Assignment a = getAssignmentById(id);
			a.setGrade(grade);
			s.update(a);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
				return false;
			}
			LogUtil.logException(e, AssignmentHibernate.class);
		} finally {
			s.close();
		}

		return true;
	}

	@Override
	public boolean updateAssignment(Assignment a) {
		log.trace("Updating assignment id "+a.getId());
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(a);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
				return false;
			}
			LogUtil.logException(e, AssignmentHibernate.class);
		} finally {
			s.close();
		}

		return true;
	}
	
	
	

}
