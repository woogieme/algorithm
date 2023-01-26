package com.ssafy.f_interface.inter.staticdefault;

interface Aircon {
    void makeCool();

    // TODO: 2. 건조기능을 추가해보자.
    // END:
    default void dry() {
    	System.out.println("이것은 기본 메서드입니다");
    };
    // TODO: 3.Aircon이 동작 방식에 대해 설명해보자.
    // END:
    static void info() {
    	System.out.println("냉매를 이용한다던가..");
    }

}

class OldisButGoodies1 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

// TODO: 1. 무풍 에어컨을 구현해보자.
class NowindAircon implements Aircon{

	@Override
	public void makeCool() {
		// TODO Auto-generated method stub
		System.out.println("바람없이 시원함");
	}

	@Override
	public void dry() {
		// TODO Auto-generated method stub
		System.out.println("종료 시 자동 건조 해줍니다~~");
	}
	
	
}
// END:

public class StaticDefaultMethod {
    public static void main(String[] args) {
        Aircon[] aircons = { new OldisButGoodies1(), new OldisButGoodies2() };
        for (Aircon aircon : aircons) {
            if (aircon == null) {
                continue;
            }
            aircon.makeCool();
        }
    }
}
