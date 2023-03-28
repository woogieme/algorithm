package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭_부분집합2 {
	static int N,M=0;
	static int[] cards;
	static boolean[] select;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		cards= new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < cards.length; i++) {
			cards[i]=Integer.parseInt(st.nextToken());
		}
		ans=Integer.MIN_VALUE;
		perm1(0,0,0);
		System.out.println(ans);
		
	}
	private static void perm1(int idx, int cnt,int tmp) {
		// TODO Auto-generated method stub
		if(cnt==3) {
			if(tmp<=M)
				ans = Math.max(ans,  tmp);
			return;
			
		}
		if(idx==cards.length) return; //앞에 재귀들이 너무 false , false 해서 총 3개를 못뽑음..
		perm1(idx+1,cnt+1,tmp+cards[idx]);
		perm1(idx+1,cnt,tmp);
	}


}
