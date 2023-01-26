package day01117;

public class CarTest {
	public static void main(String[] args) {
		Car c1= new Car();
		c1.price=1500;
		System.out.println("현재 예산:"+c1.price);
		
		c1.priceUp();
		System.out.println("현재 예산:"+c1.price);
		
		c1.priceUp(50);		
		System.out.println("현재 예산:"+c1.price);
		
		c1.priceUp(0.1);
		System.out.println("부가세:"+c1.price);
		
		//////////////////////////////////////////////////
		Car c2=new Car(2000, "WHITE","코나");
		System.out.println(c2.color+" : "+c2.price+" : "+c2.model);
		
	}
}
