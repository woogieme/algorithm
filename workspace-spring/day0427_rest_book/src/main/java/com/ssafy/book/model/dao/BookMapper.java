package com.ssafy.book.model.dao;

import java.util.List;

import com.ssafy.book.model.dto.Book;

public interface BookMapper {
	int insert(Book b);	//책 추가	
	List<Book> selectAll(); //전체 조회
	Book selectOne(int bno); //하나 조회
	int delete(int bno); //삭제
} 
