package com.notesharing.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.GradeLevel;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;

@Repository
public class GradeLevelHibernate implements GradeLevelDAO {

	private HibernateUtil hu = HibernateUtil.getInstance();
	
	
	@Override
	public Integer createGradeLevel(GradeLevel gradeLevel) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(gradeLevel);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, CourseHibernate.class);
		} finally {
			s.close();
		}
		return gradeLevel.getGradeLevelId();
	}

	@Override
	public GradeLevel getGradeLevel(GradeLevel gradeLevel) {
		Session s = hu.getSession();
		gradeLevel = s.get(GradeLevel.class, gradeLevel.getGradeLevelId());
		s.close();
		return gradeLevel;
		
	}

	@Override
	public GradeLevel getGradeLevelById(Integer id) {
		Session s = hu.getSession();
		GradeLevel gradeLevel = s.get(GradeLevel.class, id);
		s.close();
		return gradeLevel;
		
	}

	@Override
	public Set<GradeLevel> getGradeLevels() {
		// TODO Auto-generated method stub
		Session s = hu.getSession();
		String query = "FROM grade_levels";
		Query<GradeLevel> q = s.createQuery(query, GradeLevel.class);
		List<GradeLevel> gradeLevelList = q.getResultList();
		Set<GradeLevel> gradeLevelSet = new HashSet<GradeLevel>();
		gradeLevelSet.addAll(gradeLevelList);
		s.close();
		return gradeLevelSet;
	}

	@Override
	public void updateGradeLevel(GradeLevel gradeLevel) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(gradeLevel);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, GradeLevelHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void deleteGradeLevel(GradeLevel gradeLevel) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(gradeLevel);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, GradeLevelHibernate.class);
		} finally {
			s.close();
		}
	}

}
