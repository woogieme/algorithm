package test01_추상;



public class Circle extends Shape{
	int radius;
	public Circle() {
		super(0,0);
	}
	
	public Circle(int x, int y, int r) {
		super(x,y); //x,y는 Shape의 private 이라서 자식도 어차피 접근 못함.
		this.radius=r;
	}
	public void draw(){
		System.out.println("동그라미 ㅋㅋ");
	}; 
}
