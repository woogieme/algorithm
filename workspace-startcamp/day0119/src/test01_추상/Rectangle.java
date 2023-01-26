package test01_추상;

public class Rectangle extends Shape{
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
	public void draw() {
		System.out.println("나는 사각형을 그립니다!!!");
	}
}
