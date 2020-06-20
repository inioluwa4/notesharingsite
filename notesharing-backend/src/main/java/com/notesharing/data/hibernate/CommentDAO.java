package com.notesharing.data.hibernate;

import java.util.Set;

import com.notesharing.models.Comment;

public interface CommentDAO {

	public Integer addComment (Comment comment);

	public Comment getComment (Comment comment); 
	
	public Set<Comment> getAllComments();
}
