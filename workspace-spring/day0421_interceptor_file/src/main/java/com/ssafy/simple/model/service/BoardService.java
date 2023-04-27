package com.ssafy.simple.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.simple.model.dao.BoardDao;
import com.ssafy.simple.model.dto.BoardDTO;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;
	
	public int write(BoardDTO board) throws SQLException {
		return dao.insert(board);
	}
	
	public BoardDTO read(int bno) throws SQLException {
		return dao.selectOne(bno);
	}
	
	public int remove(int bno) throws SQLException {
		return dao.delete(bno);
	}
	
	public List<BoardDTO> list() throws SQLException{
		return dao.selectAll();
	}
}










