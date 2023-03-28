package day0208;

import java.util.Arrays;

public class Ex_recursion {
	//N은 used 또는 cars 개수
	//R은 N개중 R개를 뽑기때문에 R을 설정
	static int N=4 , R=3;  
	
	static String[] cards = {"A","B","C","D"};
	static String[] result = new String[R];
	
	
	public static void main(String[] args) {
		perm(0,0);
	}
	static void perm(int idx,int start) { // 나는result의 idx칸에 집착함. 채워야돼!!!!
		if(idx==R) {
			//System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=start; i<N; i++) { //자 재료는 여러개가 있어
			result[idx]=cards[i]; // 오 사용가능한 i번 카드가 있네 ? 가져가자
			perm(idx+1,i+1); //다음 내 후배 졸라맨 너도 0번부터 카드 다 새로봐야한다.
		}
		
	}//end for perm method
}
