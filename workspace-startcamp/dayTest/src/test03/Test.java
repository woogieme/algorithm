package test03;

public class Test {
	public static void main(String[] args) {
		Car c= new Car();
		
		//c.price = 1000;	 	//public	- 단어 뜻 그대로 외부 클래스가 자유롭게 사용 [사용 잘안함]
		//c.speed = 230;   	//protected - 같은 패키지 또는 자식 클래스에서 사용 [사용 잘안함]
		//c.color = "RED"; 	//(default) - 같은 패키지에 소속된 클래스에서만 사용 [사용 잘안함]
		//c.model = "페라리";	//private  -  해당클래스 내부에서만 접근가능 [ 사용 많이함]
		c.setColor("RED");
	}
}
