package day0207;

import java.util.Arrays;

public class Test01_perm2 {
	//N은 used 또는 cars 개수
	//R은 N개중 R개를 뽑기때문에 R을 설정
	static int N=6 , R=3;  
	static int tmp;
	static String[] cards = {"A","B","C","D","E","F"};
	static boolean[] used = new boolean[N];
	static int count=0;
	static int count1=0;
	
	static String[] result = new String[R];
	
	static boolean[] used1 = new boolean[N];
	static String[] result1 = new String[R];
	
	public static void main(String[] args) {
		perm(0);
		System.out.println(count );
		perm2(0);
		System.out.println(count1 );
	}
	static void perm(int idx) { // 나는result의 idx칸에 집착함. 채워야돼!!!!
		if(idx==R) {
			System.out.println(Arrays.toString(result));
			count+=1;
			return;
		}
		for(int i=0; i<N; i++) { //자 재료는 여러개가 있어
			//if(used[i]) continue; //내 선배 재귀가 카드를 먼저 찜했네... 그건 제끼고 다음카드 보자
			result[idx]=cards[i]; // 오 사용가능한 i번 카드가 있네 ? 가져가자
			perm(idx+1); //다음 내 후배 졸라맨 너도 0번부터 카드 다 새로봐야한다.
			//used[i]=false;
		}
		
	}//end for perm method
	
	static void perm2(int idx) { // 나는result의 idx칸에 집착함. 채워야돼!!!!
		if(idx==R) {
			used1[tmp]=true;
			System.out.println(Arrays.toString(result1));
			count1+=1;
			return;
		}
		for(int i=0; i<N; i++) { //자 재료는 여러개가 있어
			if(used1[i]) continue; //내 선배 재귀가 카드를 먼저 찜했네... 그건 제끼고 다음카드 보자
			result1[idx]=cards[i]; // 오 사용가능한 i번 카드가 있네 ? 가져가자
			tmp=i;
			perm(idx+1); //다음 내 후배 졸라맨 너도 0번부터 카드 다 새로봐야한다.
			used1[i]=false;
		}
		
	}//end for perm method
}
