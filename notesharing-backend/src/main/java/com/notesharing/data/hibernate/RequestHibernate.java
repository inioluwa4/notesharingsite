package com.notesharing.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.notesharing.models.Request;
import com.notesharing.utils.HibernateUtil;
import com.notesharing.utils.LogUtil;


@Repository
public class RequestHibernate implements RequestDAO{

	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public Integer createRequest(Request request) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(request);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, RequestHibernate.class);
		} finally {
			s.close();
		}
		return request.getRequestId();
	}

	@Override
	public Request getRequest(Request request) {
		Session s = hu.getSession();
		request = s.get(Request .class, request.getRequestId());
		s.close();
		return request;
		
	}

	@Override
	public Request getRequestById(Integer id) {
		Session s = hu.getSession();
		Request request = s.get(Request.class, id);
		s.close();
		return request;
		
	}

	@Override
	public Set<Request> getRequests() {
		Session s = hu.getSession();
		String query = "FROM Request";
		Query<Request> q = s.createQuery(query, Request.class);
		List<Request> requestList = q.getResultList();
		Set<Request> requestSet = new HashSet<Request>();
		requestSet.addAll(requestList);
		s.close();
		return requestSet;
	}

	@Override
	public void updateRequest(Request request) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(request);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, RequestHibernate.class);
		} finally {
			s.close();
		}
	}

	@Override
	public void deleteRequest(Request request) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(request);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, RequestHibernate.class);
		} finally {
			s.close();
		}
	}

}
