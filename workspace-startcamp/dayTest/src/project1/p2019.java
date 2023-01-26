package project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2019 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력>>");
		int N=Integer.parseInt(br.readLine());
		int sum=0;
		for(int i=1; i<=N; i++) {
			if(i%2==0) sum+=i;
		}
		System.out.println("1부터 10까지 수 중 짝수의 합 = "+sum);
		
	}
}
