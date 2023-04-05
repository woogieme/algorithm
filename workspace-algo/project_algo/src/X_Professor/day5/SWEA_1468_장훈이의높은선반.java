package X_Professor.day5;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1468_장훈이의높은선반 {
	static int N;
	static int M;
	static int R;
	static int[] arr;
	static int[] cards;
	static boolean[] selected;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= tc; TC++) {
			
			StringTokenizer st =new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			st =new StringTokenizer(br.readLine());
			arr =new int [N];
			cards =new int [N];
			selected =new boolean [N];
			for (int i = 0; i < N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			ans=Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				R=i+1;
				comb(0,0);
				
			}
			System.out.println("#"+TC+" "+ans);
		
		}
		
	}
	static void comb(int idx, int cnt) {
		if(cnt==R) { //오 R개 뽑았대
			int sum=0;
			for (int i = 0; i < selected.length; i++) {
				if(selected[i]) {
					sum+=arr[i];
				}
			}
			if(sum>=M) {
				sum=sum-M;
				ans=Math.min(ans,sum);
			}
			return;
		}
		
		if(idx==N) return;
		// TODO Auto-generated method stub
		selected[idx]=true;
		comb(idx+1,cnt+1);
		selected[idx]=false;
		comb(idx+1,cnt);
	}
}
