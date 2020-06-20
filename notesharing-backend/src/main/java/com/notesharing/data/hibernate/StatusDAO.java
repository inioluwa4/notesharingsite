package com.notesharing.data.hibernate;

import com.notesharing.models.Status;

public interface StatusDAO {

	public Status getStatus(Status status);
	public void updateStatus(Status status);
}
