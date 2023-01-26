package test02_인터페이스;

//인터페이스 implements 하면 강제성이 생긴다 
//해당하는 추상메소드를 구현해야하는 강제성
public class Rectangle extends Shape implements Drawable{
	int width, height;
	
	//컴파일러 기본 제공 
//	public Rectangle() {
//		super();
//	}
	
	public Rectangle() {
		super(0,0);
	}
	
	public Rectangle(int x, int y, int w, int h) {
		super(x,y); //x,y는 Shape의 private 이라서 자식도 어차피 접근 못함.
		this.width=w;
		this.height=h;
	}
	
	@Override
	public void draw() {
		System.out.println("나는 사각형을 그립니다!!!");
	}
}
