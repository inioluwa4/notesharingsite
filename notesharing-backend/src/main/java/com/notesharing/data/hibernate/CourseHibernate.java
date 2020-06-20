package com.notesharing.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Course;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;

@Repository
public class CourseHibernate implements CourseDAO{

private HibernateUtil hu = HibernateUtil.getInstance();
	
	



	@Override
	public Integer createCourse(Course course) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(course);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, CourseHibernate.class);
		} finally {
			s.close();
		}
		return course.getCourseId();
		
	}

	@Override
	public Course getCourse(Course course) {
		Session s = hu.getSession();
		course = s.get(Course.class, course.getCourseId());
		s.close();
		return course;
		
	}

	@Override
	public Course getCourseById(Integer id) {
		Session s = hu.getSession();
		Course course = s.get(Course.class, id);
		s.close();
		return course;
		
	}

	@Override
	public Set<Course> getCourses() {
		Session s = hu.getSession();
		String query = "FROM courses";
		Query<Course> q = s.createQuery(query, Course.class);
		List<Course> courseList = q.getResultList();
		Set<Course> courseSet = new HashSet<Course>();
		courseSet.addAll(courseList);
		s.close();
		return courseSet;
	}

	@Override
	public void updateCourse(Course course) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(course);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, CourseHibernate.class);
		} finally {
			s.close();
		}
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
			LogUtil.logException(e, CourseHibernate.class);
		} finally {
			s.close();
		}
	}

	
}
