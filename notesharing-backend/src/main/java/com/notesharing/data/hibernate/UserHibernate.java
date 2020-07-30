package com.notesharing.data.hibernate;


import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Login;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;


@Repository
public class UserHibernate implements UserDAO {
	private Logger log = Logger.getLogger(UserHibernate.class);

	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public Login getUser(String username, String password) {
		log.trace("Trying to Find User "+username+", "+password);
		log.trace("");

		Session s = hu.getSession();
		String query = "from Login u where u.username=:username and u.password=:password";
		Query<Login> q = s.createQuery(query, Login.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		Login u = (Login) q.uniqueResult();
		s.close();
		return u;
	}



}
