package X_swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5215_햄버거_다이어트 {
	static int N;
	static int L;
	static boolean[] selected;
	static ArrayList<Position> arr;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M =Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <=M; tc++) {
		st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		
		arr= new ArrayList<>(); 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		answer=Integer.MIN_VALUE;
		selected = new boolean[N];
		DuplicatePerm(0);
		System.out.println("#"+tc+" "+answer);
		}
	}
	
	private static void DuplicatePerm(int idx) {
		// TODO Auto-generated method stub
		if(idx==N) {
			int sumKcal=0,sumFlavor=0;
			for (int i = 0; i < selected.length; i++) {
				if(selected[i]) {
					sumFlavor+=arr.get(i).x;
					sumKcal+=arr.get(i).y;
				}
			}
			if(sumKcal<=L) {
				if(sumFlavor>=answer) {
					answer=sumFlavor;
				}
			}
			return;
		}
		selected[idx]=true;
		DuplicatePerm(idx+1);
		selected[idx]=false;
		DuplicatePerm(idx+1);
	}

	static class Position{
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
