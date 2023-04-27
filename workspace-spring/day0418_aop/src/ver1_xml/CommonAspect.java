package ver1_xml;

import org.springframework.stereotype.Component;

// 여러 클래스에 공통적으로 적용시키고자 하는 기능
// 아래의 before, after, after-returning, after-throwing 중 필요한 것만 선택적으로 구현해도 됨.
//@Component
public class CommonAspect {
	public void bbbefore() { // 핵심관심사항(point-cut)을 실행시키기 직전 시점
		System.out.println("배가 많이 고프다. 오늘 급식이 진짜 파이였음.");
	}
	
	public void aaafter() {
		System.out.println("설거지를 한다."); // 예외발생 여부와 상관없이. finally 개념임.
	}
	
	public void aaafterReturning() {
		System.out.println("냠냠 맛있게 먹는다.");
	}
	
	public void aaafterThrowing() {
		System.out.println("양유쌤한테 울면서 전화한다.");
	}
}
