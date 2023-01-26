package com.ssafy.b_abstraction.person;

public class Person {
	//속성
	static String org="SSAFY";
	String name;
	int age;
	boolean isHungry;

	//동작
	void work() {
		isHungry = true;
	}
	void eat() {
		isHungry = false; 
	}
	

	void printInfo() {
		System.out.println(name+" : "+age +" : "+isHungry);
		
	}
	
}
