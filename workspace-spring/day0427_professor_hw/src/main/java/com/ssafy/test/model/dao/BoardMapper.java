package com.ssafy.test.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.test.model.dto.Board;

@Mapper
public interface BoardMapper {

	public List<Board> selectAll();


	public int insert(Board board);


	public Board read(int bno); 

}
