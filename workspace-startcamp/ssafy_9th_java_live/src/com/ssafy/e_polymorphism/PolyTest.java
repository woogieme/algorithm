package com.ssafy.e_polymorphism;

import com.ssafy.c_inheritance.person.SpiderMan;
import com.ssafy.c_inheritance.person.Person;
class Venom extends SpiderMan{
	public Venom() {
		super("",true);
	}
	
}
public class PolyTest {
	public static void main(String[] args) {
		SpiderMan onlyOne = new SpiderMan("피터파커",false);
		
		SpiderMan sman=onlyOne;
		//조상 타입으로 자식 갬체 참조!! --> 다형성!!!
		
		Person person = onlyOne;
		//묵시적 형변환
		Object obj=onlyOne;
		//묵시적 형변환
		
		//하나의 객체로 여러개를 참조할수있다.
	}
}
