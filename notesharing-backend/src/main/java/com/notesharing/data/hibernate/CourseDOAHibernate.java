package com.notesharing.data.hibernate;


import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Course;
import com.notesharing.models.Login;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;


@Repository
public class CourseDOAHibernate implements CourseDAO {
	private Logger log = Logger.getLogger(CourseDOAHibernate.class);

	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public List<Course> getCoursesByUser(Login user) {
		log.trace("Getting courses for user "+user.getUsername());
		log.trace("");
		int user_id = user.getId();

		Session s = hu.getSession();
		String query = "from Course c where c.course_user=:user";
		Query<Course> q = s.createQuery(query, Course.class);
		q.setParameter("user", user);
		List<Course> courseList = q.getResultList();
		s.close();
		return courseList;
	}

	@Override
	public Boolean addCourse(Course course) {
		Integer id = null;
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			id = (Integer) s.save(course);
			t.commit();
		} catch(HibernateException e) {
			if (t != null)
				t.rollback();
			LogUtil.logException(e, CourseDOAHibernate.class);
			return false;

		} finally {
			s.close();
			return id>0;
		}
	}

	
	@Override
	public Course updateCourse(Course course) {
		log.trace("Updating course "+ course);
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(course);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
				return null;
			}
			LogUtil.logException(e, CourseDOAHibernate.class);
		} finally {
			s.close();
		}

		return course;
	}
	
	@Override
	public void deleteCourse(Course course) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(course);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, CourseDOAHibernate.class);
		} finally {
			s.close();
		}
	}



}
