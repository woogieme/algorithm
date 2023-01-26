package day0116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test08 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1.5판 3승 ");
		System.out.println("2.3판 2승 ");
		System.out.println("3.1판 1승 ");
		int T=Integer.parseInt(br.readLine());
		
		System.out.println("번호를 입력하세요 "+T);
		int count=0;
		int k=0;
		boolean isFalse=false;
		switch(T){
		case 1:
			count=5;
			k=3;
			break;
		case 2:
			count =3;
			k=2;
			break;
		case 3:
			count =1;
			k=1;
			break;
		}
		int i_Human=0;
		int i_Com=0;
		for(int i=0; i<count; i++) {
			System.out.print("가위바위보 중 하나 입력: ");
			String human=br.readLine();
			int com = (int)(Math.random()*3)+1;
			
			if (human.equals("가위")) {
				
				if (com ==1) {
					System.out.println("비겼습니다");
					
				}
				if(com==2) {
					System.out.println("졌습니다");
					i_Com+=1;
				}
				if(com==3) {
					System.out.println("이겼습니다");
					i_Human+=1;
				}
			}
			
			if (human.equals("주먹")) {
				if (com ==1) {
					System.out.println("이겼습니다");
					i_Human+=1;
				}
				if(com==2) {
					System.out.println("비겼습니다");
					
				}
				if(com==3) {
					System.out.println("졌습니다");
					i_Com+=1;
				}
			}
			
			if (human.equals("보")) {
				if (com ==1) {
					System.out.println("졌습니다");
				}
				if(com==2) {
					System.out.println("이겼습니다");
					i_Human+=1;
				}
				if(com==3) {
					System.out.println("비겼습니다");
					i_Com+=1;
				}
			}
			if (i_Human==k) {
				System.out.println("### 사람 승!!!!");
				isFalse=true;
			}
			else if (i_Com==k) {
				System.out.println("### 컴퓨터 승!!!!");
				isFalse=true;
			}
			
		}
		if (!isFalse) {
			if (i_Human<i_Com) {
				System.out.println("### 컴퓨터 승!!!!");
			}
			else {
				System.out.println("### 사람 승 !!!!");
			}
		}
		
		
	}

}
