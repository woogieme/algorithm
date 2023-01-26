package test02_인터페이스;

//인터페이스 implements 하면 강제성이 생긴다 
//해당하는 추상메소드를 구현해야하는 강제성
public class Circle extends Shape implements Drawable{
	int radius;
	public Circle() {
		super(0,0);
	}
	
	public Circle(int x, int y, int r) {
		super(x,y); //x,y는 Shape의 private 이라서 자식도 어차피 접근 못함.
		this.radius=r;
	}
	@Override
	public void draw(){
		System.out.println("동그라미 ㅋㅋ");
	}; 
}
