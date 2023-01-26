package test01;

import java.util.LinkedList;
import java.util.ArrayList;
//자바 배열사이즈를 먼저 안다면  배열사용 [속도가빠름]
//자바 배열사이즈를 모른다면 arraylist 사용
public class Test01 {
	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(100);
		System.out.println(list1.size());
		list1.add(300);
		list1.add(10);
		list1.add(200);
		list1.add(500);
		list1.add(1,500);
		System.out.println(list1.size());
		System.out.println(list1);
		LinkedList<Car> list2 = new LinkedList<>();
		// <???> 작성자는 ???해놓을게  
		list2.add(new Car());
		list2.add(new Car());
		list2.add(new Car());
		
		// Object로 하면안돼? -> Object의 맹점은 너무 넓다 [자유도가 너무 높다.]
		LinkedList list3 = new LinkedList<>();
		list3.add("String");
		list3.add(100);
		list3.add(new Car());
		//넣을때는 괜찮지만 뺄때 문제다 
		//System.out.println(list3.get(2)+100); 을한다면
		//The operator + is undefined for the argument type(s) Object, int 라는 문제가 생김
		// Object + int 연산수행은 말이안됨.
		//System.out.println((Integer)list3.get(2)+100);//로 다시한다면
		// java.lang.ClassCastException: day0120.Car cannot be cast to java.lang.Integer 라는 문제로
		//객체를 Integer로 바꿀수없기때문에 다시 오류가 일어난다

		//이런 문제들때문에 Object는 쓸수없으니 타입을 미정처리 한것이다.
		//LinkedList<E> list3 = new LinkedList<>(); E는 element
		//E는 무엇이 될지 모르는 미정이다.
		
		
		//wrapper class란?
		//list3.add(100); 라면 100이라는 숫자가 들어와서 다시 Integer 객체로 감싸서 보내주는 행위, 감싼다하여 wrapper class로 말한다
		//예시는 Integer, String 객체
	}

}
