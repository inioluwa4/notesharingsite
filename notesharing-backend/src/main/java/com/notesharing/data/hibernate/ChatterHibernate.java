package com.notesharing.data.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Assignment;
import com.notesharing.models.Chatter;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;

@Repository
public class ChatterHibernate implements ChatterDAO {
	private static HibernateUtil hu = HibernateUtil.getInstance();

	private Logger log = Logger.getLogger(ChatterHibernate.class);


	@Override
	public Chatter createMessage(Chatter message) {
		// Add message to the database.
		Integer id = null;
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			id = (Integer) s.save(message);
			t.commit();
		} catch(HibernateException e) {
			if (t != null)
				t.rollback();
			LogUtil.logException(e, ChatterHibernate.class);
			return null;

		} finally {
			s.close();
		}
		return message;
	}

	@Override
	public List<Chatter> getAllUnreadMessages(int userId) {
		// Get all messages.
		
			log.trace("Getting all messages for user Id "+userId);
	
			Session s = hu.getSession();
			Query<Chatter> q = s.createQuery("FROM Chatter where reciever =:id", Chatter.class);
			q.setParameter("id", userId);
			List<Chatter> messageList = q.getResultList();
			s.close();
			return messageList;
	}

	@Override
	public Chatter updateMessage(Chatter message) {
		log.trace("Updating message "+ message);
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(message);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
				return null;
			}
			LogUtil.logException(e, ChatterHibernate.class);
		} finally {
			s.close();
		}

		return message;
	}

}
