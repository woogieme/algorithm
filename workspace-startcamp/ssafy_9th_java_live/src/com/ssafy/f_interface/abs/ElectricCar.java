package com.ssafy.f_interface.abs;

// TODO: Vehicle을 상속받는 구조로 변경해보자.
class ElectricCar extends Vehicle{
	@Override
	public void addFuel(){
		System.out.printf("급속 충전");
	}
}