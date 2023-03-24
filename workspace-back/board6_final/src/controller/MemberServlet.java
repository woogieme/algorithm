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
public class MemberServlet extends HttpServlet {
	private MemberService mservice = new MemberService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		if(action.equals("logout")) {
			req.getSession().invalidate(); // 지금 request보낸 사용자거 세션객체 폐기!!!!
			resp.sendRedirect(req.getContextPath()); // 메인페이지로 이동
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		try {
			if (action.equals("login")) {
				String id = req.getParameter("userId");
				String pw = req.getParameter("userPw");
				MemberDto loginInfo = mservice.login(id, pw);
				if(loginInfo != null) { // 로그인 성공!!
					HttpSession session = req.getSession();
					session.setAttribute("loginInfo", loginInfo); // 로그인 기록!!
//					resp.sendRedirect(req.getContextPath()+"/index.jsp");
					resp.sendRedirect(req.getContextPath()); // 메인페이지로 이동
				}else {
					req.setAttribute("errorMsg", "아이디 또는 패스워드가 잘못되었습니다.");
					req.getRequestDispatcher("Error.jsp").forward(req, resp);
				}
			}
		} catch (Exception e) {
			req.getRequestDispatcher("Error.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
}
