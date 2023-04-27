package ver1_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TomcatMain {
	// 내일 모레부터는 실제로 톰캣 돌리겠지만 오늘은 없으니까 그냥 테스트용 메인
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ver1_xml/beans.xml");
		
		Car sonata = ctx.getBean("sonata", Car.class);
//		Tire tire = ctx.getBean("ccc", Tire.class);
//		
//		sonata.setTire(tire);
		
		sonata.run();
		
	}
}
