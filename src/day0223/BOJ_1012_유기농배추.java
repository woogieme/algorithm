package day0223;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012_유기농배추 {
	static int[][] map;
	static int M;
	static int N;
	static int isWorm;
	static boolean[][] visited;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			N=sc.nextInt();
			M=sc.nextInt();
			map = new int[N][M];
			isWorm= sc.nextInt();
			for (int i = 0; i < isWorm; i++) {
				int x =sc.nextInt();
				int y =sc.nextInt();
				map[x][y]=1;
			}
			ans=0;
			visited= new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1 && visited[i][j]==false) {
						BFS(i,j,visited);
						ans++;
					}
				}
			}
			System.out.println(ans);
			
		}
	}
	private static void BFS(int i, int j, boolean[][] visit) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(i,j));
		visit[i][j]=true;
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d <4; d++) {
				int nexti= now.x+dx[d];
				int nextj= now.y+dy[d];
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]==1 && !visit[nexti][nextj] ) {
					visit[nexti][nextj]=true;
					queue.add(new Point(nexti,nextj));
				}
			}
		}
		
	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
