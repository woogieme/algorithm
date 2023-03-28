package day0207;

import java.util.Arrays;

public class Test01_perm {
	//N은 used 또는 cars 개수
	//R은 N개중 R개를 뽑기때문에 R을 설정
	static int N=4 , R=3;  
	
	static String[] cards = {"A","B","C","D"};
	static boolean[] used = new boolean[N];
	
	static String[] result = new String[R];
	
	
	public static void main(String[] args) {
		perm(0);
	}
	static void perm(int idx) { // 나는result의 idx칸에 집착함. 채워야돼!!!!
		if(idx==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=0; i<N; i++) { //자 재료는 여러개가 있어
			if(used[i]) continue; //내 선배 재귀가 카드를 먼저 찜했네... 그건 제끼고 다음카드 보자
			result[idx]=cards[i]; // 오 사용가능한 i번 카드가 있네 ? 가져가자
			used[i]=true;
			perm(idx+1); //다음 내 후배 졸라맨 너도 0번부터 카드 다 새로봐야한다.
			used[i]=false;
		}
		
	}//end for perm method
}
