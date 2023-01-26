package com.ssafy.f_interface.abs;

public class VehicleTest {

  public static void main(String[] args) {
    // TODO: DieselSUV와 ElectricCar를 각각 한대씩 관리하는배열을 만들고 사용해보자.
		Vehicle[] vehicles = { new DieselSUV(), new ElectricCar() };

		for (Vehicle v: vehicles) {
				v.addFuel();
				v.reportPosition();
				// 만약 조상클래스에 같은 메소드가 없다면 아래와 같은 동작을 해줘야함.
//				if(v instanceof DieselSUV) {
//					DieselSUV d= (DieselSUV)v;
//					d.addFuel();
//				}
		}
    // END:
  }

}
