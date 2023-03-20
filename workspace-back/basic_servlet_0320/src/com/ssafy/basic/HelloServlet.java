package com.ssafy.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//해야할것들
		response.setContentType("text/html;charset=utf8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("body");
		out.println("Hello Servlet!!!");
		out.println("</body>");
		out.println("</html>");
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		//해야할것들
//		response.setContentType("text/html;charset=utf8");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("body");
//		out.println("Hello Servlet!!!");
//		out.println("</body>");
//		out.println("</html>");
//	}
	
}
