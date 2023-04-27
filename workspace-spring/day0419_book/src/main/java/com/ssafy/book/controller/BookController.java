package com.ssafy.book.controller;

import java.sql.SQLException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.book.model.dto.Book;
import com.ssafy.book.model.service.BookService;

@Controller // @Component, @Repository, @Service 얘네는 기능이 같음. 컨트롤러만 왕따임
public class BookController {
	@Autowired
	private BookService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public ModelAndView list() throws SQLException {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("booklist"); // /WEB-INF/views/booklist.jsp
		ModelAndView mv = new ModelAndView("booklist");
		mv.addObject("books", service.getAll());
		return mv;
	}
	
	@GetMapping("/write") // 이건 주소표시줄에 나타나는 url
	public String write() {
		return "bookwrite"; // 이건 jsp파일 이름 => /WEB-INF/views/bookwrite.jsp
	}
	
	@PostMapping("/write")
	public String write(Book book) throws SQLException { // 4개의 파라미터를 get 해서 알아서 dto에 set, set,.. 으로 넣어줌.
		if(service.add(book)) {
			return "add_success";
		}else {
			return "add_fail";
		}
	}
	
	@GetMapping("/delete")
	public String delete(int bno) throws SQLException {
		service.remove(bno);
//		return "booklist"; // WEB-INF/views/booklist.jsp 이러면 안됨. 데이터가 .jsp한테 안감.
		return "redirect:list";
	}
	
	@PostMapping("/deleteAll")
	public String deleteAll(int[] bno) throws SQLException {
		System.out.println(Arrays.toString(bno));
		if(bno!=null && bno.length>0)
			service.removeAll(bno);
		return "redirect:list";
	}
}







