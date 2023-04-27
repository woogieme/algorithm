package ws2.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @Controller : HttpRequest 받는 웹 컨트롤러는 @Component말고 컨트롤러 붙여놔야함. 서비스 가져다 쓸수 있음.
public class TomcatTest {
//	@Autowired
//	private BoardService service;
	
	public static void main(String[] args) throws SQLException {
		// 여기가 돌아갈 수 있도록 실습하세요
		// 다 하면 나한테 다했다고 MM하기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		// ws1 : xml 태그로 객체 등록해서 실행시키기
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ws2/model/beans.xml");
		BoardService service=ctx.getBean("sss", BoardService.class); 
		BoardService service2 = new BoardService();
		
		for(BoardDto dto: service2.getBoards()) {
			System.out.println(dto);
		}
		
		
	}
}
