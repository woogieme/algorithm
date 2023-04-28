package com.ssafy.test.model.dao;

import java.util.List;

import com.ssafy.test.model.dto.Comment;

public interface CommentMapper {
	
	public int insert(Comment comment);
	public List<Comment> showComment(int bno);
}
