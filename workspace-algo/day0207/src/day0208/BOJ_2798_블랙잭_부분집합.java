package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798_블랙잭_부분집합 {
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
		select = new boolean[N];
		perm1(0,0);
		System.out.println(ans);
		
	}
	private static void perm1(int idx, int cnt) {
		// TODO Auto-generated method stub
		if(cnt==3) {
			int tmp=0;
			for (int i = 0; i < select.length; i++) {
				if(select[i]) {
					tmp+=cards[i];
				}
			}
			
			if(tmp<=M) ans=Math.max(ans,tmp);
			return;
			
		}
		if(idx==cards.length) return; //앞에 재귀들이 너무 false , false 해서 총 3개를 못뽑음..
		select[idx]=true;
		perm1(idx+1,cnt+1);
		select[idx]=false;
		perm1(idx+1,cnt);
	}


}
