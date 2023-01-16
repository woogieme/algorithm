package day0111;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) { 
			//Ctrl+Shift+F : 자동완성 (문법오류나면 정렬안됨)
			//Ctrl+Shift+S : 자동정렬
			//System.out.println("안녕하세요. 9기 대전5반 여러분 반갑습니다!^^"); //sysout (Ctrl+Shift+F)
			//Scanner or BufferdReader를 이용해서 키보드 입력을 받습니다.
			//Scanner는 띄어쓰기로 구분된 정수 입력 받을때만 쓸게요. 그거 하나만 장점임
			//Scanner의 단점은 메모리, 속도 딸리고 문자 섞어 입력받을 때 개행 관련 버그가 있어요.
			Scanner sc = new Scanner(System.in);
			
			int TC = sc.nextInt(); // 테스트 반복 횟수
			for (int tc = 1; tc <=TC; tc++) { 
				//tc 테스트 시작
				int sum = 0;
				for(int i=0; i<10; i++) {
					int num= sc.nextInt(); //정수 하나 키보드로 입력받기.
					if (num%2!=0) { //홀수가 맞는지 조건문 검사.
						sum+=num;
					}
				}
				System.out.println("#"+tc+" "+sum);
			}//tc 테스트 끝
	}
}
