package day0216;

import java.util.Scanner;

public class BOJ_14888_연산자끼워넣기_Improved {
	static char[] cards;
	static char[] result;
	static boolean[] used;
	static int ansMax, ansMin,N;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers= new int[N];
		cards = new char[N-1]; //연산자는 숫자보다 한개 적
		result = new char[N-1];
		used = new boolean[N-1];
		
		ansMax = Integer.MIN_VALUE;
		ansMin = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		int cardIdx = 0;
		for (int i = 0; i < 4; i++) { //4가지 연산자 입력 들어옴
			int count= sc.nextInt();
			for (int j = 0; j < count; j++) {
				switch(i) {
				case 0:
					cards[cardIdx++]='+'; break;
				
				case 1:
					cards[cardIdx++]='-'; break;
				
				case 2:
					cards[cardIdx++]='*'; break;
				
				case 3:
					cards[cardIdx++]='/'; break;
				}
			}
		}
		perm(0);
		System.out.println(ansMax+" : "+ansMin);
	}
	static void perm(int idx) {
		if(idx ==result.length) { // 원하는 만큼 채워짐!  순열 하나 완성이니 계산해보자
			int tmp =0;
			tmp+=numbers[0];
			for (int i = 1; i < result.length; i++) {
				if(result[i]=='+') tmp+=result[i];
				else if(result[i]=='-') tmp-=result[i];
				else if(result[i]=='*') tmp*=result[i];
				else tmp/=result[i];
			}
			ansMax=Math.max(tmp, ansMax);
			ansMin=Math.min(tmp, ansMin);
			
		}
		for (int i = 0; i < cards.length; i++) {
			if(used[i]) continue;
			result[idx] = cards[i];
			used[i]=true;
			perm(idx+1);
			used[i]=false;
		}
	}
}