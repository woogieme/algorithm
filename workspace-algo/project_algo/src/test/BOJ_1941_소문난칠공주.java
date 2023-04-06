package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1941_소문난칠공주 {
	static char[][] map;
	static int result = 0 ;
	static boolean[] select;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	static int ans;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		map = new char[5][];
		select = new boolean[25];
		ans=0;
		for (int i = 0; i < args.length; i++) {
			map[i] =sc.next().toCharArray();
		}
		
		comb(0,0);
		System.out.println(ans);
	}
	static void comb(int idx, int cnt) {
		if(cnt==7) {  ///그냥 일단 아무거나 7칸 뽑았음;
			// 1. 7명 다 붙어있는지 체크
			boolean isSeven = false;
			for (int i = 0; i < 25; i++) {
				if(select[i]) {
					isSeven = bfs(i);
					break;
				}
			}
			// 2. S가 4개 이상인지 체크 
			int scnt=0;
			for (int i = 0; i < 25; i++) {
				if(select[i] && map[i/5][i%5]=='S') {					
					scnt++;
				}
			}
			if(isSeven && scnt>=4) { //뽑은 7개가 모두 붙어있고 S가 4개 이상이면 경우의 수 카운트
				ans++;
			}
			return;
		}
		if(idx==25) {
			return;
		}
		
		
		select[idx]= true;
		comb(idx+1,cnt+1);
		select[idx]=false;
		comb(idx+1,cnt);
	}
	private static boolean bfs(int start) {
		int si = start/5;
		int sj = start%5;
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visit =new boolean [5][5];
		queue.add(new Point(si,sj));
		
		int cnt=0;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			cnt++;
			if(cnt==7){
				return true;
			}
			for (int d = 0; d < 4; d++) {
				int ni = now.i+di[d];
				int nj = now.j+dj[d];
				
				if(ni>=0 && ni<5 && nj>=0 && nj<5 && select[ni*5+ nj] && !visit[ni][nj]) {
					queue.add(new Point(ni,nj));
					visit[ni][nj]=true;
				}
			}
		}
		return false;
	}
	
	static class Point {
		int i,j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
	}
}
