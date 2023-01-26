package com.ssafy.b_abstraction.person;

public class PersonTest {
	
	public static void main(String[] args) {
		System.out.println(Person.org); //객체의 생성과는 무관!!!
		
		// 객체 사용
		Person p = new Person();
		//static은 모든 객체가 공유한다.
		p.org="SSAFY2"; //static 방법으로 접근해야한다고 경고를 줌 [바람직하지않는 코드]
		p.name ="홍길동";
		p.isHungry =true;
		p.eat();
		//System.out.println(p.name+" : "+p.isHungry+": "+p.age);
		
		Person p2=new Person();
		p2.name="장길산";
		p2.work();
		//System.out.println(p2.org);
		//System.out.println(p2.name+" : "+p2.isHungry+": "+p2.age);
		p.printInfo();
		p2.printInfo();
		
	}

}
