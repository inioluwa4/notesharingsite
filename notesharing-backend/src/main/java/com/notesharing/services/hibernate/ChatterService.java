package com.notesharing.services.hibernate;

import java.util.List;

import com.notesharing.models.Assignment;
import com.notesharing.models.Chatter;
import com.notesharing.models.Course;

public interface ChatterService {
	public Chatter createMessage(Chatter message);
	public List<Chatter> getAllUnreadMessages(int userId);
	public Chatter updateMessage(Chatter message);

}
