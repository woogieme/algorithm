package com.ssafy.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterTest
 */
@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParameterTest() {
        super();
        // TODO Auto-generated constructor stub
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String username=request.getParameter("username");
//		String userpwd=request.getParameter("userpwd");
//		String[] fruit=request.getParameterValues("fruit");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println(username+" "+userpwd+" "+Arrays.toString(fruit));
//		out.println("</body>");
//		out.println("</html>");
//		
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		///1번
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		String[] fruit=request.getParameterValues("fruit");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(username+" "+userpwd+" "+Arrays.toString(fruit));
		out.println("</body>");
		out.println("</html>");
		
		//2번
		//doGet(request,response);
	}

}
