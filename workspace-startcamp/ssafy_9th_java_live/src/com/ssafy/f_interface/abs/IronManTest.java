package com.ssafy.f_interface.abs;

public class IronManTest {
	public static void main(String[] args) {
		IronMan iman = new IronMan();
		Object obj = iman;
		Heroable hero = iman;
		Fightable fight = iman;
		Transformable trans = iman;
	}
}
