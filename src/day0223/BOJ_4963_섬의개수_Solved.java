package day0223;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4963_섬의개수_Solved {
	static int[] di= {-1,-1,0,1,1,1,0,-1};
	static int[] dj= {0,1,1,1,0,-1,-1,-1};
	static int ans;
	static int H;
	static int W;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			W = sc.nextInt();
			H = sc.nextInt();
			ans=0;
			if(W==0 && H==0) break; //입력애ㅣ 무제한 들어오아 0 0 들어오면 끝
			
			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j]=sc.nextInt();
				}
			}//end input
			
			
			visit = new boolean[H][W];
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j]==1 && ! visit[i][j]) {
						bfs(i,j,visit);
						ans++;
					}
				}
			}
			System.out.println(ans);
			
		}
	}
	private static void bfs(int si, int sj, boolean[][] visit) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(si,sj));
		visit[si][sj]=true;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < 8; d++) {
				int nexti  = now.i+di[d];
				int nextj  = now.j+dj[d];
				if(nexti>=0 & nexti<H && nextj>=0 && nextj<W && map[nexti][nextj]==1 && !visit[nexti][nextj]) {
					queue.add(new Point(nexti, nextj));
					visit[nexti][nextj]=true;
				}
			}
		}
		
	}
	static class Point{
		int i,j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
