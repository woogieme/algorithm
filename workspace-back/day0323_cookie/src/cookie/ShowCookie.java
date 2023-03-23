package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showCookie")
public class ShowCookie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = req.getCookies();
		
		System.out.println("-----------------------");
		for(Cookie c: cookies) {
			if(c.getName().equals("name")) {
				System.out.println("너의 이름은 " + c.getValue());
			}
		}
		
		for(Cookie c: cookies) {
			System.out.println("니가 들고온 쿠키다?>>"+c.getName()+"//"+c.getValue());
		}
		System.out.println("-----------------------");
		
	}
	
}
