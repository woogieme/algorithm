package com.ssafy.test.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.model.dao.BoardMapper;
import com.ssafy.test.model.dto.Board;

@Service
public class BoardService {
	
	
	@Autowired
	private BoardMapper bDao;

	public List<Board> list() {
		// TODO Auto-generated method stub
		return bDao.selectAll();
	}

	public int write(Board board) {
		int result = bDao.insert(board);
		return result;
		
	}

	public Board read(int bno) {
		// TODO Auto-generated method stub
		return bDao.read(bno);
		
	}
}
