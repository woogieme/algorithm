package day0208;

import java.util.Arrays;

public class Test_부분집합 {
	static int N= 5, R;
	static String[] cards= {"A","B","C","D","E"};
	//static String[] result = new String[R];
	static boolean[] select = new boolean[cards.length];
	
	public static void main(String[] args) {
		
		for (int i = 0; i < N; i++) {
			R=i+1
					;
			comb(0,0);
		}
	}

	static void comb(int idx, int cnt) {
		if(cnt==R) { //오 R개 뽑았대
			System.out.println(Arrays.toString(select));
			return;
		}
		
		if(idx==N) return;
		// TODO Auto-generated method stub
		select[idx]=true;
		comb(idx+1,cnt+1);
		select[idx]=false;
		comb(idx+1,cnt);
	}
}
