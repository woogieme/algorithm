package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.BookManagerDao;
import model.IBookManager;


@WebServlet("/bookList")
public class BookListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("책 목록에 대한 요청이 들어왔다? 어떻게 보여주지???");
		IBookManager dao = BookManagerDao.getInstance(); //디지 작업 잘하는 객체있어 데리고와.
		
		List<Book> bookList = dao.selectAll(); //야! 데이터베이스에서 책 다 꺼내서 객체로 만들어서 리스트에 담아줘!
		resp.setContentType("text/html; charset=utf-8"); // ㄳ
		PrintWriter out = resp.getWriter();
		
		out.append("<html>");
		out.append("<head>");
		out.append("	<title>책 목록 페이지</title>");
		out.append("</head>");
		out.append("<body>");
		out.append("	<table>");
		out.append("		<tr>");
		out.append("			<th>ISBN</th>");
		out.append("			<th>제목</th>");
		out.append("			<th>저자</th>");
		out.append("			<th>출판사</th>");
		out.append("			<th>가격</th>");
		out.append("		</tr>");
		for(Book b: bookList) {
			out.append("		<tr>");
			out.append("			<th>"+b.getIsbn()+"</th>");
			out.append("			<th><a href='/day0320_Test/bookdetail?isbn="+b.getIsbn()+"'>"+b.getTitle()+"</a></th>");
			out.append("			<th>"+b.getAuthor()+"</th>");
			out.append("			<th>"+b.getPublisher()+"</th>");
			out.append("			<th>"+b.getPrice()+"</th>");
			out.append("		</tr>");
		}
		out.append("</table>");
		out.append("</body>");
		out.append("</html>");
		
		
		
	}
	
	

}
