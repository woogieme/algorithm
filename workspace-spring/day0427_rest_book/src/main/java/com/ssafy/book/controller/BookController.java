package com.ssafy.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.service.BookService;

@RestController
@RequestMapping("/book") //localhost:8080/bookcafe/book (Get,Post,Put,Delete)
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping			//localhost:8080/bookcafe/book
	public List<Book> getBooks(){
		return service.getBooks();
	}
	
	@GetMapping("/{bbb}")
	public Book getBook(@PathVariable("bbb")int bno){ //localhost:8080/boocafe/book?bno=17   
		return service.getBook(bno);
	}
	
	@PostMapping
	public int addBook(Book b) {
		return service.add(b);
	}
	
	@DeleteMapping
	public int removeBook(int bno) {
		return service.remove(bno);
	}

}
