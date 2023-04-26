package com.ssafy.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.test.Model.Service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	
	
	@GetMapping("/list")
	public ModelAndView list() throws Exception {
		
		k
	}
}
