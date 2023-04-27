package ver1_xml_around;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ver1_xml_around/beans.xml");
		
		Boy sumin = ctx.getBean("sumin", Boy.class);
		Girl jimin = ctx.getBean("jimin", Girl.class);
		
		sumin.makeFood();
		jimin.makeFood();
	}
}
