package com.notesharing.services.hibernate;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesharing.data.hibernate.RequestDAO;
import com.notesharing.models.Request;

@Service
public class RequestServiceHibernate implements RequestService{
	
	private Logger log = Logger.getLogger(RequestServiceHibernate.class);
	@Autowired
	private RequestDAO rd;
	
	
	@Override
	public Integer createRequest(Request request) {
		log.trace("attempting to create request");
		rd.createRequest(request);
		return request.getRequestId();
	}

	@Override
	public Request getRequest(Request request) {
		log.trace("attempting to get request");
		if(request == null) {
			return null;
		}else rd.getRequest(request);
		return request;
	}

	@Override
	public Request getRequestById(Integer id) {
		log.trace("attempting to get request");
		if(id == null) {
			return null;
		}else {
			Request request = rd.getRequestById(id);
			return request;
		}
	}

	@Override
	public Set<Request> getRequests() {
		log.trace("attempting to get all requests");
		Set<Request> allRequests = rd.getRequests();
		return allRequests;
	}

	@Override
	public void updateRequest(Request request) {
		log.trace("attempting to update request");
		rd.updateRequest(request);
	}

	@Override
	public void deleteRequest(Request request) {
		log.trace("attempting to delete request");
		rd.deleteRequest(request);
		
	}

}
