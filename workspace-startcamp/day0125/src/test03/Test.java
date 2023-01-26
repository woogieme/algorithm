package test03;

import java.io.IOException;

public class Test {
	public static void main(String[] args)  {
		Student s1 = new Student();

		try {
		s1.setScore(10); //비 checked 예외
		}catch (JaeUkException e) {
			// TODO: handle exception
			System.out.println("60점미만은 가라....");
		}catch(IOException e) {
			e.printStackTrace();
		}
			
		
		s1.printInfo();
		System.out.println("프로그램 종료");
	}
}
//서버에게 알릴땐 throw
//내부적으로 고쳐야하는게 try - catch 를 한다.
