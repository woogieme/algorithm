package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class p2021_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		while(i<3) {
			System.out.print("월 입력>>");
			int N=Integer.parseInt(br.readLine());
			switch(N){
			case 3:
			case 4:
			case 5:
				System.out.println(N+"월은 봄입니다");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println(N+"월은 여름입니다");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println(N+"월은 가을입니다");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println(N+"월은 겨울입니다");
				break;
			}
		}

	}
}
