package com.ssafy.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.board.dao.BoardDao;
import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 글제목, 글내용을 얻으세요.
		response.setContentType("text/html; charset=utf-8");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String userid = request.getParameter("userid");
		PrintWriter out = response.getWriter();
//		2. 1의 data를 BoardDao의 writeArticle()메소드에 전달하고 DB에 insert 하세요.
		BoardDao dao = BoardDaoImpl.getBoardDao();
		BoardDto data = new BoardDto(0,userid,subject, content,0,"0");
		int result= dao.writeArticle(data);
		
		
//		3. 2의 결과에 따라 결과 화면을 출력하세요.
		if(result==1) {
			out.append("<html>");
			out.append("<head>");
			out.append("	<title>책 목록 페이지</title>");
			out.append("</head>");
			out.append("<body>");
			out.append("	게시글 추가완료");
			out.append("<a href='index.html'"+"[전체 목록]"+"</a>");
			out.append("/body");
			out.append("<html>");
			
		}
		else {
			out.append("<html>");
			out.append("<head>");
			out.append("	<title>책 목록 페이지</title>");
			out.append("</head>");
			out.append("<body>");
			out.append("	게시글 추가실패");
			out.append("<a href='index.html'"+"[전체 목록]"+"</a>");
			out.append("/body");
			out.append("<html>");
			
		}
	}

}
