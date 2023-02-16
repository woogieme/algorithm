package day0216;

import java.util.Scanner;

public class BOJ_14888_연산자끼워넣기_Improved2 {
	static int ansMax, ansMin,N;
	static int[] numbers;
	static int[] op;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers= new int[N];
		
		ansMax = Integer.MIN_VALUE;
		ansMin = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		op = new int[4];
		for (int i = 0; i < 4; i++) { //4가지 연산자 갯수 입력
			op[i]= sc.nextInt();   //각각 몇개씩 있는지 0:+, 1:-, 2:*,3:/
		}
		calc(0,numbers[0]);
		System.out.println(ansMax);
		System.out.println(ansMin);
	}
	static void calc(int idx,int tmp) {
		if(idx == N-1) {//원하는만큼 채워짐! 순열 하나 완성이니 계산해보자!, 연산자는 숫자보다 하나 적어서
			ansMax = Math.max(tmp,ansMax);
			ansMin = Math.min(tmp,ansMin);
			return;
		}
		if(op[0]>0) {// +
			op[0]--;
			calc(idx+1,tmp+numbers[idx+1]);
			op[0]++;
		}
		
		if(op[1]>0) {// -
			op[1]--;
			calc(idx+1,tmp-numbers[idx+1]);
			op[1]++;
		}
		if(op[2]>0) {// *
			op[2]--;
			calc(idx+1,tmp*numbers[idx+1]);
			op[2]++;
		}
		if(op[3]>0) {// /
			op[3]--;
			calc(idx+1,tmp/numbers[idx+1]);
			op[3]++;
		}
	}
}