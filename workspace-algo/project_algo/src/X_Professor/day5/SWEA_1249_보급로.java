package X_Professor.day5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1249_보급로 {
	static int N;
	static int[][] map;
	static int[][] saveMap;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int K = sc.nextInt();
		for (int tc = 1; tc <=K; tc++) {
			
			N = sc.nextInt();
			map = new int [N][N];
			saveMap = new int [N][N];
			
			for (int i = 0; i < N; i++) {
				char[] tmp = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j]= tmp[j]-'0';
					saveMap[i][j] = Integer.MAX_VALUE;
				}
			}
			BFS(0,0);
			System.out.println("#"+tc+" "+saveMap[N-1][N-1]);
		}
		
		
		//showMap();
		
	}

	private static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(x,y));
		saveMap[x][y]=0;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nexti = now.x+dx[d];
				int nextj = now.y+dy[d];
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && saveMap[nexti][nextj]>map[nexti][nextj] + saveMap[now.x][now.y]) {
					saveMap[nexti][nextj] = map[nexti][nextj] + saveMap[now.x][now.y];
					queue.add(new Point(nexti,nextj));
				}
			}
			
			
			
		}
		
	}

	private static void showMap() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
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
}
