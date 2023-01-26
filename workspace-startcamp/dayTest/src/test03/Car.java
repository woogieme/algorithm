package test03;

public class Car {
	//////////////////////////////field of Class
	private int price;
	private String model;
	private String color;
	private int speed;
	//////////////////////////////method of Class
	public Car(){
		
	}
	public Car(int price, String model, String color, int speed) {
		super();
		this.price = price;
		this.model = model;
		this.color = color;
		this.speed = speed;
	}


	@Override
	public String toString() {
		return "Car [price=" + price + ", model=" + model + ", color=" + color + ", speed=" + speed + "]";
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
}
