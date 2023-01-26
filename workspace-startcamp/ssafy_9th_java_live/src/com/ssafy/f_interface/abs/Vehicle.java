package com.ssafy.f_interface.abs;

class Vehicle{
	private int curX, curY;

	public void reportPosition(){
		System.out.printf("현재 위치: (%d, %d)\n", this.curX, this.curY);
	}
	public void addFuel(){
		System.out.printf("모든 운송 수단은 연료가 필요");
	}
}
