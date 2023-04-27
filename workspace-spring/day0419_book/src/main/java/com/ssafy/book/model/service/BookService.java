package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.model.dao.BookDao;
import com.ssafy.book.model.dto.Book;

@Service
public class BookService {
	@Autowired
	private BookDao dao;
	
	public boolean add(Book book) throws SQLException {
		if(dao.insert(book)>0)
			return true;
		else
			return false;
	}
	
	public List<Book> getAll() throws SQLException{
		return dao.selectAll();
	}
	
	public void remove(int bno) throws SQLException {
		dao.delete(bno);
	}
	
	public void removeAll(int[] bno) throws SQLException {
		for(int bn: bno) {
			dao.delete(bn);
		}
	}
}




