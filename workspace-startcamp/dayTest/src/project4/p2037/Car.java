package project4.p2037;

public class Car {
	 String VIN;
	 String modelName;
	 String color;
	 int mileage;
	
	public Car() {}
	public Car(String vIN, String modelName, String color, int mileage) {
		super();
		VIN = vIN;
		this.modelName = modelName;
		this.color = color;
		this.mileage = mileage;
	}
	@Override
	public String toString() {
		return "Car [VIN=" + VIN + ", modelName=" + modelName + ", color=" + color + ", mileage=" + mileage + "]";
	}
	
}
