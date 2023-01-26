package com.ssafy.f_interface.abs;

// TODO: Vehicle을 상속받는 구조로 변경해보자.
class DieselSUV extends Vehicle{

	@Override
	public void addFuel(){
		System.out.printf("주요소에서 급유");
	}
}