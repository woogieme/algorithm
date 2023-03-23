package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDto;
import model.BoardService;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private BoardService service = BoardService.getInstance(); // MVC 중에 M을 담당하는 객체

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		try {
			if (action == null || action.equals("list")) {
				List<BoardDto> boardList = service.getBoards();
				req.setAttribute("boardList", boardList);
				req.getRequestDispatcher("BoardList.jsp").forward(req, resp);
			} else if (action.equals("write")) {
				req.getRequestDispatcher("BoardWrite.jsp").forward(req, resp);
				// 지금처럼 jsp한테 딱히 보내줄 Attribute 없으면 리다이렉트해도 되는 상황임.
//				resp.sendRedirect("BoardWrite.jsp");
			} else if(action.equals("read")) {
				String bno = req.getParameter("bno"); // "3" 이렇게 스트링으로만 옴 무조건.
				BoardDto boardDto = service.read(Integer.parseInt(bno));
				req.setAttribute("boardDto", boardDto);
				req.getRequestDispatcher("BoardRead.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// 만약 에러 발생하면 무조건 Error html 화면 만들어줄거임.
			e.printStackTrace();
			req.getRequestDispatcher("Error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		String action = req.getParameter("action");

		try {
			if (action.equals("write")) {
				String a = req.getParameter("aaa");
				String b = req.getParameter("bbb");
				String c = req.getParameter("ccc");

				BoardDto board = new BoardDto(a, b, c, ""); // 작성일시는 디비에서 now()로 알아서 들어감.
				int result = service.write(board);
				if(result==1) {
					req.getRequestDispatcher("BoardWriteSuccess.jsp").forward(req, resp);
				}else {
					req.getRequestDispatcher("BoardWriteError.jsp").forward(req, resp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			req.getRequestDispatcher("Error.jsp").forward(req, resp);
		}
	}
}
