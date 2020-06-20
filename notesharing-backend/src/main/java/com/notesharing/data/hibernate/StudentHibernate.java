package com.notesharing.data.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Course;
import com.notesharing.models.Instructor;
import com.notesharing.models.Student;
import com.notesharing.utils.HibernateUtil;



@Repository

public class StudentHibernate implements StudentDAO{
	private Logger log = Logger.getLogger(StudentHibernate.class);

	private static HibernateUtil hu = HibernateUtil.getInstance();





	@Override
	public Student getStudent (String user, String pass) {
		log.trace("Getting Student "+user+", "+pass);
		Session s = hu.getSession();
		Query<Student> q = s.createQuery("FROM Student where username =:username and password=:password", Student.class);
		q.setParameter("username", user);
		q.setParameter("password",  pass);
		Student a = q.uniqueResult();
		s.close();
		return a;
	}

	@Override
	public Student getStudentById(int id) {
		log.trace("Getting Student by Id "+id);
		Session s = hu.getSession();
		Student ret = s.get(Student.class, id);
		s.close();
		return ret;
	}

	@Override
	public List<Instructor> getAllStudents() {
		log.trace("Getting all Instructors");

			Session s = hu.getSession();
			String query = "FROM Student";
			Query<Instructor> q = s.createQuery(query, Instructor.class);
			List<Instructor> instrList = q.getResultList();
			s.close();
			return instrList;

	}

	@Override
	public List<Student> getAllStudentsByCourse(Course course) {
		//Getting all students by CourseId
		log.trace("Getting all students for course "+ course);
		Session s = hu.getSession();
		Query<Student> q = s.createQuery("FROM Student where course =:course", Student.class);
		q.setParameter("course", course);
		List<Student> a = q.getResultList();
		s.close();		
		return a;
	}

	@Override
	public List<Student> getStudentsByInstrument(int instrumentId) {
		//Getting all students by instrument
		log.trace("Getting all students for course "+ instrumentId);
		Session s = hu.getSession();
		Query<Student> q = s.createQuery("FROM Student where instrumentTypeId =:id", Student.class);
		q.setParameter("id", instrumentId);
		List<Student> a = q.getResultList();
		s.close();		
		return a;
	}

}
