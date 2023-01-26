package day01117;

public class CarTest2 {
	public static void main(String[] args) {
		
		// 1번
		Car c1 = new Car(1000,"WHITE","소나타");
		Car c2 = new Car(700,"RED","아우디");
		Car c3 = new Car(1500,"YELLOW","람보르기니");
		
		///////////////////////////////////////////////////////////////
		//2번
		Car[] cars = new Car[3]; //1개 생성된거임 new가 1라서 1개임 아무튼 그럼. 객체가 3개라고 생각하지말자. new해주지않는다면 null 이 들어가고, 무언가를 할때 오류가 생기는것임.
		cars[0] = new Car(1000,"WHITE","소나타");
		//cars[1] = new Car(700,"RED","아우디"); 
		cars[2] = new Car(1500,"YELLOW","람보르기니");
		
		for (int i = 0; i < cars.length; i++) {
			if (cars[i]!=null) {
			System.out.println(cars[i].price); //이중 하나라도 객체가 null 즉 비어있다면 java.lang.NullPointerException 라는 오류가 생기는것임.
			}
		}
		int[] nums = new int[3];
		
	}

}
