package com.ssafy.simple.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.simple.model.dto.BoardDTO;
import com.ssafy.simple.model.dto.MemberDTO;
import com.ssafy.simple.model.service.BoardService;
import com.ssafy.simple.model.service.MemberService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
//	@Autowired
//	private MemberService mservice;

//	@GetMapping("/list")
//	public ModelAndView list() throws SQLException { // 에러 처리 방법 2가지임.
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("list.jsp");
//		mv.addObject("boardList", service.list());
//		return mv;
//	}
	@GetMapping("/list")
	public ModelAndView list() { // 에러 처리 방법 2가지임.
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("boardList", service.list());
			mv.setViewName("list"); // list.jsp
		} catch (SQLException e) {
			mv.addObject("errorMsg", "글 목록 작업중에 예외가 발생하였습니다.");
			mv.setViewName("error"); // error.jsp
			e.printStackTrace();
		}
		return mv;
	}

	@GetMapping("/write")
	public String write(HttpSession session) {
		return "write"; // 로그인 된 애는 글쓰기화면 보여주면 됨.
	}

	@PostMapping("/write")
	public String write(BoardDTO board,MultipartFile yangyuFile, HttpSession session) throws SQLException, IllegalStateException, IOException {
		board.setBwriter(((MemberDTO) session.getAttribute("loginInfo")).getUserId());
		
		String savedPath = "c:/SSAFY/uploaded";
		File savedDir = new File(savedPath); // 이게 서버 컴퓨터에 파일 저장할 폴더임.
		if(!savedDir.exists()) {
			savedDir.mkdir(); // 폴더 없으면 생성해라.
		}
		
		// 저장할 땐 파일이름 겹칠까봐 랜덤값 쓰기
		String savedName = new Random().nextInt(100000000)+"";
		File savedFile = new File(savedPath+"/"+savedName); // c:/SSAFY/uploaded/584438451
		yangyuFile.transferTo(savedFile);
		
		System.out.println
		("지금 글쓰기에 첨부되어 업로드되는 파일 : "+yangyuFile.getOriginalFilename()+"/"+savedName);
		
		service.write(board);
		return "redirect:list";
	}
}
