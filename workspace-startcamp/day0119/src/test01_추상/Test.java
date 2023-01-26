package test01_추상;

public class Test {
	public static void main(String[] args) {
//		Circle c =new Circle();
//		Rectangle r =new Rectangle();
//		
//		c.draw();
//		r.draw();
		
		Shape[] shapes = new Shape[3];
		shapes[0] =new Circle();
		shapes[1] =new Rectangle();
		shapes[2] =new Rectangle();
		System.out.println(((Circle)shapes[0]).radius);
		for (Shape s : shapes) {
			s.draw();
		}

	}
}
