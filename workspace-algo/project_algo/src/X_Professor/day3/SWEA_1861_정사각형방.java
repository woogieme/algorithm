package X_Professor.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int ans;
	static int cnt;
	static int tmp;
	static Queue<Point> arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int K= Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= K; tc++) {
			arr= new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans=Integer.MIN_VALUE;
			cnt = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <N; j++) {
					BFS(i,j);
				}
			}
			Point latter = arr.poll();
			int x=latter.x;
			int y=latter.y;
			int size= arr.size();
			for (int i = 0; i < size; i++) {
				Point now = arr.poll();
				//System.out.println(now.x);
				if(now.x<x && y==now.y) {
					
					x=now.x;
					y=now.y;
				}
				else if(y<now.y) {
					x=now.x;
					y=now.y;
				}
				
				
			}
			System.out.println("#"+tc+" "+x+" "+y);
//			System.out.println("#"+tc+" "+arr[0]+" "+arr[1]);
//		
		}
		
	}
	private static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		queue.add(new Point (x,y));
		visited[x][y]=true;
		int size=0;
		int count=0;
		while(!queue.isEmpty()) {
			size = queue.size();
			for (int i = 0; i < size; i++) {
				Point now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nexti =now.x+dx[d];
					int nextj =now.y+dy[d];
					if(nexti>=0 && nexti < N && nextj>=0 && nextj<N  && map[nexti][nextj]== map[now.x][now.y]+1 && !visited[nexti][nextj]) {
						queue.add(new Point(nexti,nextj));
						visited[nexti][nextj]=true;
					}
				}
			}
			count++;
		}
		arr.add(new Point(map[x][y],count));
		//System.out.println(map[x][y]+" "+count);
	}
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}	
