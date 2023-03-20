package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookManagerDao;
import model.IBookManager;

@WebServlet("/bookWrite")
public class bookWriteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf8");
		String isbn = req.getParameter("isbn");
		String  title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");		
		String price = req.getParameter("price");
		String desc = req.getParameter("desc");
		String quantity = req.getParameter("quantity");
		
		PrintWriter out = resp.getWriter();
		if(isbn==null || isbn.length()==0 || price==null || price.length()==0) {
			out.append("<html>");
			out.append("<head>");
			out.append("	<title>책 목록 페이지</title>");
			out.append("</head>");
			out.append("<body>");
			out.append("	입력오류");
			out.append("/body");
			out.append("<html>");
		}
		else {
			
		IBookManager dao = BookManagerDao.getInstance();
		Book book =new Book(isbn, title,author, publisher, Integer.parseInt(price), desc,Integer.parseInt(quantity));
		dao.insert(book);
		out.append("<html>");
		out.append("<head>");
		out.append("	<title>책 목록 페이지</title>");
		out.append("</head>");
		out.append("<body>");
		out.append("	책 추가완료");
		out.append("<a href='booklist'"+"[전체 목록]"+"</a>");
		out.append("/body");
		out.append("<html>");
		}
		
			
		
		
	}
	
	

}
