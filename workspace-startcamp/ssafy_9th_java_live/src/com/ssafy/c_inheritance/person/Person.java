package com.ssafy.c_inheritance.person;

public class Person {
	String name;
	public Person() {}
	public Person(String name) {
		this.name = name;
	}
	public void eat() {
		System.out.println("냠냠");
	}
	
	public void eat(String tool) {
		System.out.println(tool+"을 이용해서");
		//System.out.println("냠냠");
		this.eat();
	}
	public void jump() {
		System.out.println("쩝쩝");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", toString()=" + super.toString() + "]";
	}
	
}
