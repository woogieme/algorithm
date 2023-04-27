package ver2_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// BoardService -> Dao 의존하는 클래스.
@Component ("sonata") // <bean> 태그 역할 이름을 지정하지 않으면 클래스명 첫글자 소문자로 자동으로 이름붙음.
public class Car {
	@Autowired // 아래 Tire 타입에 올수 있는 객체가 있는지 스프링이 탐색한다음 끌고옴.
//	@Qualifier("koreaTire")
	private Tire tire; // 나는 디비작업 해야될 때 타이어객체가 필요하다.
	private String color;
	
//	public Car() { // 이렇게 기본생성자 제공 안하는 라이브러리 있으면 <bean> 태그에 <constructor-arg> 태그 필수인 경우 있음.
//	}
//	
	public Car(Tire tire) {
		this.tire = tire;
	}
////////////////////////////////////////////////////////////////////////
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void run() {
		System.out.println("차량 주행중(서비스 객체 일하는 중 with Tire)");
		System.out.println("장착 타이어 정보 : "+tire.getModel());
	}
	
	public void aaa() {
		System.out.println("드라이브 가자 유후~");
	}
	
	public void bbb() {
		System.out.println("집에가자 피곤하다..");
	}
}
