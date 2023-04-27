package ver1_xml_around;

import org.aspectj.lang.ProceedingJoinPoint;

public class CommonAspect {
	public void aaaround(ProceedingJoinPoint joinPoint) {
		System.out.println("배가 고프다."); // before
		try {
			joinPoint.proceed();// 이게 Boy 또는 Girl에 있는 핵심관심사항 수행 시점
			System.out.println(); // after returning
		} catch (Throwable e) {
			System.out.println("양유쌤한테 울면서 전화한다."); // after throwing
			e.printStackTrace();
		} finally {
			System.out.println("설거지를 한다."); // after
		}
	}
}
