package com.ssafy.f_interface.abs;

public class IronMan implements Heroable{
	int weaponDamage=100;


	@Override
	public void changeShape(boolean isHeroMode) {
		// TODO Auto-generated method stub
		System.out.println("수트 변경");
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		System.out.println("버전up");
	}

	@Override
	public int fire() {
		System.out.println("발사");
		return 0;
	}

}
