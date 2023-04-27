package ver2_annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TomcatMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ver2_annotation/beans.xml");
		
		Car sonata = ctx.getBean("sonata", Car.class);
//		Tire tire = ctx.getBean("koreaTire", Tire.class);
//		
//		sonata.setTire(tire);
		sonata.run();
	}
}
