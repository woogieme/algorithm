package Test01;

import java.util.Scanner;

public class test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력");
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.println(" 이름이 뭐에요");
		//String name = sc.next(); //공백 있으면 안읽음
		String name = sc.nextLine(); //공백 있으면 안읽음
		
		System.out.println(name + "님 반갑습니다."+num);
		
	}
}
