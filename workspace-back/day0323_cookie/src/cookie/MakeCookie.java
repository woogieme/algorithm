package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makeCookie")
public class MakeCookie extends HttpServlet{
	static int cookieNum=0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		
		System.out.println(req.getLocalAddr()+"가 지금 쿠키 만들어 달라고 요청 보냈네");
		System.out.println("너의 이름은"+name +"이구나. 지금 쿠키 발급했다 확인해봐라.");
		
		cookieNum++;
		Cookie c1 = new Cookie("cookie"+cookieNum, "Yangyusmakecookieforyou");
		Cookie c2 =new Cookie("name",name);
		
		resp.addCookie(c1);
		resp.addCookie(c2);
		
		
	}
	
}
