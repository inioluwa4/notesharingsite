package com.notesharing.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Uniform;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;

@Repository
public class UniformHibernate implements UniformDAO{

	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public Integer createUniform(Uniform uniform) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(uniform);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UniformHibernate.class);
		} finally {
			s.close();
		}
		return uniform.getId();
	}

	@Override
	public Uniform getUniform(Uniform uniform) {
		Session s = hu.getSession();
		uniform = s.get(Uniform.class, uniform.getId());
		s.close();
		return uniform;
	}

	@Override
	public Uniform getUniformById(Integer id) {
		Session s = hu.getSession();
		Uniform uniform = s.get(Uniform.class, id);
		s.close();
		return uniform;
	}

	@Override
	public Set<Uniform> getUniforms() {
		Session s = hu.getSession();
		String query = "FROM Uniform";
		Query<Uniform> q = s.createQuery(query, Uniform.class);
		List<Uniform> uniformList = q.getResultList();
		Set<Uniform> uniformSet = new HashSet<Uniform>();
		uniformSet.addAll(uniformList);
		s.close();
		return uniformSet;
	}
	
	@Override
	public Set<Uniform> getUnapprovedUniforms(){
		Session s = hu.getSession();
		String query = "select u from Uniform u\r\n" + 
				"join Inventory inv on u.id = inv.id\r\n" + 
				"Left Outer join Request req on inv.id = req.inventory\r\n" + 
				"where req.status is null or req.status != 2";
		Query<Uniform> q = s.createQuery(query, Uniform.class);
		List<Uniform> uniformList = q.getResultList();
		Set<Uniform> uniformSet = new HashSet<Uniform>();
		uniformSet.addAll(uniformList);
		s.close();
		return uniformSet;
	}

	@Override
	public void updateUniform(Uniform uniform) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(uniform);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UniformHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void deleteUniform(Uniform uniform) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(uniform);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, UniformHibernate.class);
		} finally {
			s.close();
		}
	}
	
}
