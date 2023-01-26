package com.ssafy.e_polymorphism;

import com.ssafy.c_inheritance.person.Person;
import com.ssafy.c_inheritance.person.SpiderMan;

public class PolymorphismUsage {
    public void useObjectArray() {
        // TODO:Object []을 선언하고 다양한 객체를 저장하고 저장된 클래스 타입을 출력하세요.
    	Object[] objs = new Object[4];
    	objs[0]="Hello";
    	objs[1]= new Person();
    	objs[2]= new SpiderMan("",false);
    	objs[3]=3; //autoboxing - 자동적으로 형변환 원래는 Integer.valueOf(3);
    	
    	for (int i = 0; i < objs.length; i++) {
			System.out.println(objs[i].getClass().getName());
		}
    	//autobox unboxing
    	int a = 10;
    	Integer aobj = a; //int ==> Integer : autoboxing;
    	int sum = a+ aobj; //Integer ==> int : unboxing;
    	// int sum2 = a+ aobj.intValue(); 
        // END:
    	
    	Object obj = objs[1];
    	
    	if(obj instanceof Person) {
    		Person p=(Person)obj;
    		System.out.println(p.toString());
    		p.eat();
    	}
    	else {
    		System.out.println(obj.getClass().getName());
    	}
    	
    	
    }

    public void useObjectParam() {
//        System.out.println(1);
//        System.out.println("Hello");
//        System.out.println(new Person());
//        System.out.println(new SpiderMan());
    }

    public static void main(String[] args) {
        PolymorphismUsage usage = new PolymorphismUsage();
        usage.useObjectArray();
        usage.useObjectParam();
    }
}
