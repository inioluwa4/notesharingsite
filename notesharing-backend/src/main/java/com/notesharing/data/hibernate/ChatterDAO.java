package com.notesharing.data.hibernate;

import java.util.List;

import com.notesharing.models.Assignment;
import com.notesharing.models.Chatter;


public interface ChatterDAO {
	
	public Chatter createMessage(Chatter message);
	public List<Chatter> getAllUnreadMessages(int userId);
	public Chatter updateMessage(Chatter message);


}
