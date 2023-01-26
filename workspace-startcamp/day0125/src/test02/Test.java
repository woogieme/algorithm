package test02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요>>");
		try {
			int num=sc.nextInt();
			System.out.println("나누기 결과: "+(100/num));
		}catch(InputMismatchException ex) {
			System.out.println("숫자 입력하라고오오오");
		}finally {
			//주로 리소스 반납하는 문장을 여기 적습니다.
			//자바는 가비지컬렉터가 있어서 반납 필요 없는거 아닌가요??
			//프로그램 내부에서 사용한 객체등의 리소스는 자동 반납이 되지만 프로그램 외부와 통신 관련 리소스는
			//별도로 close 해서 반납해야 합니다.
			System.out.println("예외가 발생하든 안하든, 발생했다면 그 예외가 catch됐든 안됐든 무조건 실행");
		}
		
		System.out.println("프로그램이 종료됩니다");
	}
}
