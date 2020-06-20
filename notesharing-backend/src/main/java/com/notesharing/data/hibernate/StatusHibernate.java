package com.notesharing.data.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Status;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;

@Repository
public class StatusHibernate implements StatusDAO{
	
	private HibernateUtil hu = HibernateUtil.getInstance();

	
	@Override
	public Status getStatus(Status status) {
		Session s = hu.getSession();
		status = s.get(Status.class, status.getStatusId());
		s.close();
		return status;
	}

	@Override
	public void updateStatus(Status status) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(status);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, StatusHibernate.class);
		} finally {
			s.close();
		}
	}
}
