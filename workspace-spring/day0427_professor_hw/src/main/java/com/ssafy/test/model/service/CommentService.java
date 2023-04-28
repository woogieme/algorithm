package com.ssafy.test.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.model.dao.CommentMapper;
import com.ssafy.test.model.dto.Comment;

@Service
public class CommentService {

	
	@Autowired
	private CommentMapper cDao;
	
	public int insert(Comment comment) {
		return cDao.insert(comment);
	}
	public List<Comment> showComment(int bno){
		return cDao.showComment(bno);
	}
}
