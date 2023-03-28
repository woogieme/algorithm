package day0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int N;
	static int M;
	static int[] di= {-1,0,1,0};
	static int[] dj= {0,1,0,-1};
	static int[][] map;
	static boolean[][] visited;
	static int x;
	static int y;
	static int d;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans=0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		visited =new boolean[N][M];
		while(true) {
//		1.현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(!visited[x][y]) {
				visited[x][y]=true;
				ans++;
			}
//		2.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
			boolean isClean=true;
			for (int d = 0; d < 4; d++) {
				int nexti=x+di[d];
				int nextj=y+dj[d];
				if(map[nexti][nextj]==0 && !visited[nexti][nextj]) {
					isClean=false;
				}
				
			}
//			2-1. 현재 칸의 주변4칸 중 청소되지 않은 빈 칸이 없는 경우, (청소 안해도 됨 isClean true) 
//			바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
//			바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.

			if(isClean) {
				int backi = x + di[(d+2)%4];
				int backj = y + dj[(d+2)%4];
				if(map[backi][backj]==0) { // 뒤가 빈칸이면
					x = backi; // 후진
					y = backj;
				}else {
					break; // 가장 가까운 감싸진 반복문이 while(true) 임
				}
			}
			else {
				d=(d+3)%4;
				int nexti=x+di[d];
				int nextj=y+dj[d];
				if(map[nexti][nextj]==0&&!visited[nexti][nextj]) {
					x=nexti;
					y=nextj;
				}
			}
//		3.현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
//			1.반시계 방향으로 90도 회전한다.
//			2.바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
//			3.번으로 돌아간다.
		}	
		System.out.println(ans);
		
		
	}
}
