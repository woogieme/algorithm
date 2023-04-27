package ver2_annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ver2_annotation/beans.xml");
		
		Boy sumin = ctx.getBean("boy", Boy.class);
		Girl jimin = ctx.getBean("girl", Girl.class);
		
		sumin.makeFood();
		jimin.makeFood();
	}
}
