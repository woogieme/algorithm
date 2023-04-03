package X_Professor.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1861_정사각형방 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int ans;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int K= Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= K; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans=Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[] arr = new int[2];
			for (int i = 0; i < N; i++) {
				visited= new boolean[N][N];
				cnt=1;
				for (int j = 0; j < N; j++) {
					DFS(i,j,visited);
					if(ans<=cnt) {
						if(ans==cnt) {
							if(arr[0]>map[i][j]) {
								arr[0]=map[i][j];
							}
						}
						else {
							ans=cnt;
							arr[0]=map[i][j];
							arr[1]=cnt;
						}
					}
					
				}
			}
			System.out.println("#"+tc+" "+arr[0]+" "+arr[1]);
		
		}
		
	}
	private static void DFS(int x, int y, boolean[][] visit) {
		visit[x][y]=true;
		for (int d = 0; d < 4; d++) {
			int nexti=x+dx[d];
			int nextj=y+dy[d];
			if(nexti>=0 &&nexti<N &&nextj>=0 &&nextj<N &&map[nexti][nextj]==map[x][y]+1 && !visited[nexti][nextj]) {
				DFS(nexti,nextj,visit);
				cnt++;
			}
			
		}
		
		
	}
}	
