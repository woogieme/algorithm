package com.ssafy.test.Model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.test.Model.DTO.BookDao;

@Service
public class BookService {
	
	@Autowired
	private BookDao dao;
	
	

}
