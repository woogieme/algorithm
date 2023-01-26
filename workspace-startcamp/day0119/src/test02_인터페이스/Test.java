package test02_인터페이스;

public class Test {
	public static void main(String[] args) {
		PaintTool pt = new PaintTool();
		pt.add(new Rectangle(10,10,100,200));
		pt.add(new Circle(1,5,10));
		pt.add(new Circle(2,5,10));
		pt.add(new Circle(3,5,10));
		pt.add(new Circle(4,5,10));
		pt.add(new Circle(5,5,10));
		pt.add(new Circle(6,5,10));
		pt.add(new Circle(7,5,10));
		pt.add(new Circle(8,5,10));
		pt.add(new Circle(9,5,10));
		pt.add(new Circle(10,5,10));
		pt.add(new Circle(11,5,10));
		pt.add(new Circle(12,5,10));
		pt.add(new Rectangle(10,10,100,50));
		pt.add(new Rectangle(10,10,100,40));
		pt.add(new Rectangle(10,10,100,30));
		pt.add(new Rectangle(10,10,100,10));
		pt.add(new Rectangle(10,10,100,20));
		
		
		pt.drawAll();

	}
}
