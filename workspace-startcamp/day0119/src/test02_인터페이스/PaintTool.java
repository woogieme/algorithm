package test02_인터페이스;

public class PaintTool {
	private Drawable[] drawbles = new Drawable[100];
	//객체는 못만들지언정 참조변수는 선언가능함. 
	//참조변수의 타입은 나에게 들어오는데이터가 이런 타입이다라고 하는것임
	//기대치 생각하자.
	private int index=0;
	
	public void add(Drawable d) {
		drawbles[index++] = d;
		
	}
	
	//마치 이게 라이브러리의 sort처럼 동작하는 거임.
	//x,y,width 이런거 다 관심없음. draw 메소드만 관심있음.
	
	public void drawAll() {
		for (int i = 0; i < index; i++) {
			drawbles[i].draw();
		}
	}
}
