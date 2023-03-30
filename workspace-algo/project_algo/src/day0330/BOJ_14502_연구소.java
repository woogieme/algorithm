package day0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static boolean[] selected;
	static int[][] map;
	static int[][] copy;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int i;
	static int j;
	static int ans;
	static int N;
	static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		selected = new boolean [N*M];
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans=Integer.MIN_VALUE;
		comb(0,0);
		System.out.println(ans);
	}
	private static void comb(int idx, int cnt) {
		if (cnt==3) {
			int count=0;
			copyMap(map);
			for (int i = 0; i < N*M; i++) {
				if(selected[i]) {
					if(i!=0) {
						copy[i/M][i%M]=1;
					}
					else {
						copy[0][0]=1;
					}
				}
			}
			
			for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy[i].length; j++) {
					if(copy[i][j]==2) {
						BFS(i,j);
					}
				}
			}
			
//			for (int i = 0; i < copy.length; i++) {
//				for (int j = 0; j < copy.length; j++) {
//					System.out.print(copy[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			for (int i = 0; i < copy.length; i++) {
				for (int j = 0; j < copy[i].length; j++) {
					if(copy[i][j]==0) {
						count++;
					}
				}
			}
			ans = Math.max(ans, count);
			return;
		}
		if(idx==selected.length) {
			return;
		}
		
		if(idx!=0) {
			i = idx/M;
			j = idx%M;
		}else {

			i=0;
			j=0;
		}
		if(map[i][j]==0) {
			selected[idx]=true;
			comb(idx+1,cnt+1);
			selected[idx]=false;
			comb(idx+1,cnt);
		}else if(map[i][j]==2 || map[i][j]==1) {
			comb(idx+1,cnt);
		}
		
	}
	
	
	
	private static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		boolean[][] visited = new boolean[N][M];
		visited[x][y]=true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now.x+dx[d];
				int nextj = now.y+dy[d];
				if(nexti>=0 &&nexti < N &&nextj>=0 && nextj<M && copy[nexti][nextj]==0 && !visited[nexti][nextj]) {
					copy[nexti][nextj]=4;
					queue.add(new Point(nexti,nextj));
					visited[nexti][nextj]=true;
				}
			}
			
			
		}
		
	}
	
	
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			
			this.x = x;
			this.y = y;
		}
		
	}
	
	private static void copyMap(int[][] tmp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j]=tmp[i][j];
			}

		}
	}
	
	private static void cleanUp() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j]==1) {
					map[i][j]=0;
				}
			}

		}
		
	}
}
