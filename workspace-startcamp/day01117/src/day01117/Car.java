package day01117;

public class Car {
	//메소드 안에 들어가지않음
	int price; //클래스 멤버변수 == 필드 == 인스턴스(non-static) 변수
	String color; // 스태틱 변수 <=> 인스턴스 변수 [ 인스턴스 변수들은 밑으로 내려가도 상관없음 ]
	String model; //
	/////////////////////////////////////
	Car(){										//기본 생성자
		this(300,"BLACK","아반떼"); //옆에있는 다른 생성자들 호출해서 일시킬 때 this()문법을 씀.
		System.out.println("기본 생성자입니다~~");
	} 
	Car(int price, String color , String model){
		this.price = price;
		this.color = color;
		this.model = model;
	}
	/////////////////////////////////////
	void priceUp() {
		//메소드 안에 들어간 변수 => 매개변수 , 매개변수도 포함 [갈색으로 표현된 부분]
		int tmp=10;
		tmp++;
		System.out.println("priceUp()"+ tmp);
		price+=10;
	}
	
	void priceUp(int money) { //매개변수가 달라 ok
		price+=money;
	}
	void priceUp(double fee) { //타입이 달라 ok
		price +=price*fee;
	}
}
