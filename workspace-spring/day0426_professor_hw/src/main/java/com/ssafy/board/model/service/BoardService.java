package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardMapper;

@Service
public class BoardService {
	
	
	@Autowired
	private BoardMapper bDao;

}
