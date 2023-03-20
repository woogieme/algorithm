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

@WebServlet("/bookdetail")
public class BookDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String isbn = req.getParameter("isbn");
		if(isbn!=null && isbn.length()>0) { //not null and not ""
			IBookManager dao = BookManagerDao.getInstance();
			Book book = dao.selectByIsbn(isbn);
			
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.append("<html>");
			out.append("<head>");
			out.append("	<title>책 목록 페이지</title>");
			out.append("</head>");
			out.append("<body>");
			out.append("	<table>");
			out.append("<tr>");
			out.append("			<td>ISBN</td>");
			out.append("			<td>"+book.getIsbn()+"</td>");
			out.append("</tr>");
			out.append("<tr>");
			out.append("			<td>제목</td>");
			out.append("			<td>"+book.getTitle()+"</td>");
			out.append("</tr>");
			out.append("<tr>");
			out.append("			<td>상세설명</td>");
			out.append("			<td>"+book.getDesc()+"</td>");
			out.append("</tr>");
			out.append("<tr>");
			out.append("			<td>수량</td>");
			out.append("			<td>"+book.getQuantity()+"</td>");
			out.append("</tr>");
			out.append("</table>");
			out.append("</body>");
			out.append("</html>");
			
		}
	}
	
}
