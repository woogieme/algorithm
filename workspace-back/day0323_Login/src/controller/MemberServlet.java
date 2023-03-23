package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDto;
import model.MemberService;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	private MemberService mservice = new  MemberService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		
		if(action.equals("logout")) {
			req.getSession().invalidate(); // 지금 request 보낸 사용자거 새션객체 폐기
			resp.sendRedirect(req.getContextPath());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		try {
		if(action.equals("login")) {
			String id = req.getParameter("userId");
			String pw = req.getParameter("userPw");
			MemberDto logInfo=mservice.login(id, pw);
			if(logInfo !=null) {//로그인성공
				HttpSession session = req.getSession();
				session.setAttribute("loginInfo", logInfo);
				resp.sendRedirect(req.getContextPath());
			}
			else {
				req.setAttribute("errorMsg","아이디 또는 패스워드가 틀렸습니다");
				req.getRequestDispatcher("Error.jsp").forward(req, resp);;
			}
		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					throw new Exception("아이디 또는 패스워드가 잘못되었습니다");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				req.getRequestDispatcher("Error.jsp").forward(req, resp);
				e.printStackTrace();
			}
	}
		
		
}
