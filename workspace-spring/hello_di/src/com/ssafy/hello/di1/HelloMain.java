package com.ssafy.hello.di1;

public class HelloMain {

	public static void main(String[] args) {
		HelloMessageKor helloMessageKor = new HelloMessageKor();
		HelloMessageEng helloMessageEng = new HelloMessageEng();
		
		String greeting = helloMessageKor.helloKor("안효인");
		String greeting1 = helloMessageEng.helloEng("Mr. An");
		
		System.out.println(greeting);
		System.out.println(greeting1);
	}
	
}
