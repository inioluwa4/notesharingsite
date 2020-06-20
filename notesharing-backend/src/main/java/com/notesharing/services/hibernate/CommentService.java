package com.notesharing.services.hibernate;

import java.util.Set;

import com.notesharing.models.Comment;

public interface CommentService {

	public Integer addComment (Comment comment);

	public Comment getComment (Comment comment); 
	
	public Set<Comment> getAllComments();
}
