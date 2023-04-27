package ver2_annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 여러 클래스에 공통적으로 적용시키고자 하는 기능
// 아래의 before, after, after-returning, after-throwing 중 필요한 것만 선택적으로 구현해도 됨.
@Component
@Aspect // 일반 컴포넌트 객체 아니고 공통관심사항 적용 객체라고 알려주기
public class CommonAspect {
	@Pointcut("execution(* make*())")
	public void ppp() {}
	
	@Before("ppp()")
	public void bbbefore() { // 핵심관심사항(point-cut)을 실행시키기 직전 시점
		System.out.println("배가 많이 고프다. 오늘 급식이 진짜 파이였음.");
	}
	
	@After("execution(* make*())")
	public void aaafter() {
		System.out.println("설거지를 한다."); // 예외발생 여부와 상관없이. finally 개념임.
	}
	
	@AfterReturning("execution(* make*())")
	public void aaafterReturning() {
		System.out.println("냠냠 맛있게 먹는다.");
	}
	
	@AfterThrowing("execution(* make*())")
	public void aaafterThrowing() {
		System.out.println("양유쌤한테 울면서 전화한다.");
	}
}
