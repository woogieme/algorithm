package X_Professor.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int N;
	static int[][] map;
	static boolean[] selected;
	static int[] arr;
	
	static int ans; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= M; tc++) {
			
			N= Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			ans=Integer.MAX_VALUE;
			selected = new boolean[N];
			comb(0,0);
			System.out.println("#"+tc+" "+ans);
		}
		
	}
	private static void comb(int idx, int cnt) {		// TODO Auto-generated method stub
		if(cnt==N/2) {
			int sumA=0;
			int sumB=0;
			for (int i = 0; i < selected.length; i++) {
				for (int j = 0; j < selected.length; j++) {
					if(selected[i]&& selected[j])
					{
						sumA+=map[i][j];
					}
					else if(!selected[i]&& !selected[j]){
						sumB+=map[i][j];
					}
				}
			}
			ans=Math.min(ans,Math.abs(sumA-sumB));
			return;
		}
		if(idx==selected.length) {
			return;
		}
		selected[idx]=true;
		comb(idx+1,cnt+1);
		selected[idx]=false;
		comb(idx+1,cnt);
		
	}
}
