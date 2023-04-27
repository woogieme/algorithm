package com.ssafy.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // !!! Component 아님 주의
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
