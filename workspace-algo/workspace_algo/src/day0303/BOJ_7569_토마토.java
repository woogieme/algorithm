package day0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		ans=0;
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		Queue<Point> arr=new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					arr.add(new Point(i,j,0));
				}
			}
		}
		visited= new boolean[N][M];
		
		while(!arr.isEmpty()) {
			Point now = arr.poll();
			ans = now.day;
			for (int d = 0; d < 4; d++) {
				int nexti=now.x+dx[d];
				int nextj=now.y+dy[d];
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<M &&map[nexti][nextj]==0) {
					arr.add(new Point(nexti,nextj,now.day+1));
					map[nexti][nextj]=1;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					ans=-1;
				}
				
			}
		}
		System.out.println(ans);
		
		
	}
	static class Point{
		int x;
		int y;
		int day;
		public Point(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}
		
	}
}	
