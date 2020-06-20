package com.notesharing.data.hibernate;

import java.util.Set;

import com.notesharing.models.Request;

public interface RequestDAO {

	
	public Integer createRequest(Request request);
	public Request getRequest(Request request);
	public Request getRequestById(Integer id);
	public Set<Request> getRequests();
	public void updateRequest(Request request);
	public void deleteRequest(Request request);
	
	
	
}
