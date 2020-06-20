package com.notesharing.data.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.User;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;


@Repository
public class UserHibernate implements UserDAO {
	private Logger log = Logger.getLogger(UserHibernate.class);

	private HibernateUtil hu = HibernateUtil.getInstance();
	@Override
	public int addUser(User user) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(user);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
		return i;
	}

	@Override
	public User getUser(String username, String password) {
		log.trace("Trying to Find User "+username+", "+password);
		log.trace("");

		Session s = hu.getSession();
		String query = "from User u where u.username=:username and u.password=:password";
		Query<User> q = s.createQuery(query, User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		User u = (User) q.uniqueResult();
		s.close();
		return u;
	}

	@Override
	public User getUser(User u) {
		Session s = hu.getSession();
		User ret = s.get(User.class, u.getId());
		if(ret==null) {
			String query = "from User u where u.username=:username and u.password=:password";
			Query<User> q = s.createQuery(query, User.class);
			q.setParameter("username", u.getUsername());
			q.setParameter("password", u.getPassword());
			ret = q.uniqueResult();
		}
		s.close();
		return ret;
	}

	@Override
	public User getUserById(int u) {
		Session s = hu.getSession();
		User ret = s.get(User.class, u);
		s.close();
		return ret;
	}

	@Override
	public void deleteUser(User user) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(user.getId());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void updateUser(User user) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(user.getId());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, UserHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public List<User> getUsers() {
		Session s = hu.getSession();
		String query = "FROM User";
		Query<User> q = s.createQuery(query, User.class);
		List<User> userList = q.getResultList();
		s.close();
		return userList;

	}
}
