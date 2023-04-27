package ws1.model;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TomcatTest {
	public static void main(String[] args) throws SQLException {
		// 여기가 돌아갈 수 있도록 실습하세요
		// 다 하면 나한테 다했다고 MM하기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		// ws1 : xml 태그로 객체 등록해서 실행시키기
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ws1/model/beans.xml");
		BoardService service=ctx.getBean("sss", BoardService.class); 
		
		for(BoardDto dto: service.getBoards()) {
			System.out.println(dto);
		}
		
		
	}
}
