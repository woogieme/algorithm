package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	

}
