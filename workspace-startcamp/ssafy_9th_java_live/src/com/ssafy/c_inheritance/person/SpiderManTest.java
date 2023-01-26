package com.ssafy.c_inheritance.person;

public class SpiderManTest {
	public static void main(String[] args) {
		SpiderMan sman= new SpiderMan();
		sman.isSpider =false;
		sman.name ="피터 파커";
		sman.eat();
		sman.jump();
		sman.fireWeb();
		sman.isSpider =true;
		sman.fireWeb();
		sman.eat("젓가락");
		sman.jump();
		System.out.println(sman.toString());
		
		String s1 =new String("HELLO");
		String s2 =new String("HELLO");
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
	}
}
