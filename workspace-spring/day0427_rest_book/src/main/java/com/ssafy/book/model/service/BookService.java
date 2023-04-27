package com.ssafy.book.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.book.model.dao.BookMapper;
import com.ssafy.book.model.dto.Book;

@Service
public class BookService {
	@Autowired
	private BookMapper bDao;
	
	
	public int add(Book b) {
		return bDao.insert(b);
	}
	
	public List<Book> getBooks() {
		return bDao.selectAll();
	}
	
	public Book getBook(int bno) {
		return bDao.selectOne(bno);
	}
	
	public int remove(int bno) {
		return bDao.delete(bno);
	}
}
