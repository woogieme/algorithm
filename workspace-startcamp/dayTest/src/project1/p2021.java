package project1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class p2021 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<3; i++) {
			System.out.print("월 입력>>");
			int N=Integer.parseInt(br.readLine());
			if(N>=3 && N<=5) {
				System.out.println(N+"월은 봄입니다");
			}
			else if(N>=6 && N<=8) {
				System.out.println(N+"월은 여름입니다");
			}
			else if(N>=9 && N<=11) {
				System.out.println(N+"월은 가을입니다");
			}
			else if (N==12 || N==1 || N==2){
				System.out.println(N+"월은 겨울입니다");
			}
			else {
				System.out.println("오류입니다");
			}
		}

	}
}
