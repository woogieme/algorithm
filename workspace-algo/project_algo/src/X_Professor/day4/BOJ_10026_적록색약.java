package X_Professor.day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10026_적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N= sc.nextInt();
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j <N; j++) {
				map[i][j]=tmp[j];
			}
		}
		
		
		//적록색약? 구역을 나눠야됨 그렇다면 ? 차지하는공간을 알아야하니까 BFS을 사용해보도록 해보자
		
		
		//1. 일단은 정상적인 시민일때를 구해보자 
		int count=0;
		 for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='G' && !visited[i][j]) {
					BFS(i,j,map[i][j]);
					count++;
				}else if(map[i][j]=='B' && !visited[i][j]) {
					BFS(i,j,map[i][j]);
					count++;
				}else if(map[i][j]=='R' && !visited[i][j]) {
					BFS(i,j,map[i][j]);
					count++;
				}
			}
		}
		
		int countB=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='G') {
					map[i][j]='R';
				}
			}
		}
		
		visited = new boolean[N][N];

		 for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='B' && !visited[i][j]) {
					BFS(i,j,map[i][j]);
					countB++;
				}else if(map[i][j]=='R' && !visited[i][j]) {
					BFS(i,j,map[i][j]);
					countB++;
				}
			}
		}
		System.out.println(count+" "+countB);
		
		
	}
	private static void BFS(int x, int y,char value) {
		Queue<Point> queue = new LinkedList<>();
		visited[x][y]=true;
		queue.add(new Point(x,y));
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			for (int d = 0; d < dx.length; d++) {
				int nexti = now.x+dx[d];
				int nextj = now.y+dy[d];
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && map[nexti][nextj]==value && !visited[nexti][nextj]) {
					//System.out.println(map[now.x][now.y]+" "+map[nexti][nextj]+" "+value);
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
}
