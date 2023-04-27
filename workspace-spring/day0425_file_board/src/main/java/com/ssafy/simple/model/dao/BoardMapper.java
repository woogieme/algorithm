package com.ssafy.simple.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.simple.model.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	public int insert(BoardDTO board) throws SQLException ;
	public int delete(int bno) throws SQLException ;
	public List<BoardDTO> selectAll() throws SQLException;
	public BoardDTO selectOne(int bno) throws SQLException;
}
