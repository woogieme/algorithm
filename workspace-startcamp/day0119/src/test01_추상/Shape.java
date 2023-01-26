package test01_추상;

//추상 메소드가 하나라도 ! 포함되면 이제 이 클래스 객체는 생성 불가(왜있음?? 상속받는 자식 객체를 관리는 가능!)
//그렇다면 강제성이 생긴다. 상속받는 클래스들은 abstarct 메소드 내부로직으 무조건 채워줘야함 [Override 기능을 사용해서] 즉 조상클래스가 abstract 클래스고, abstract 메소드가있다면 자식 클래스는 무조건 해당 메소드를 채워줘야함.
//=> 추상 클래스를 상속받는 자식은 반드시 추상 메소드 몸통을 구현(override)해야함.. 아니면 자식도 추상클래스됨..

public abstract class Shape {
	private int x, y;
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public abstract void draw();
	
	//Shape가 draw를 하진않지만 Circle , Rectangle draw 함수를 쓰기때문에 굳이 내부 로직을 짤필요는없지만 오버라이딩을해야하기때문에 선언만해야함 그렇지만 추상적이기떄문에 abstract 추가
		//new Shape는 못하게됨 왜냐하면 draw는 추상적인 메소드기때문에 못한다는것이다. 
		//class 에 abstract 메소드가 하나라도있으면 그 class 는 abstarct class가 됨 

}
