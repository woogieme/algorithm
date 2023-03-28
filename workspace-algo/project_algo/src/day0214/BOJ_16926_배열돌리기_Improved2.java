package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기_Improved2 {
	static int N;
	static int M;
	static int R;
	static int[][] map;
	static int[] di = {0,1,0,-1};
	static int[] dj = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N=Integer.parseInt(st.nextToken());
		 M=Integer.parseInt(st.nextToken());
		 R=Integer.parseInt(st.nextToken());
		 map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int r = 0; r < R; r++) {
			rotate();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void rotate() {
		// TODO Auto-generated method stub
		int depth = Math.min(N, M)/2;
		for (int d = 0; d < depth; d++) {
			int nowi = d, nowj = d;
			int tmp = map[d][d];
			int dir=0;
			while(true) {
				int nexti = nowi +di[dir];
				int nextj = nowj +dj[dir];
				//옆칸이 더이상 가면 안되는칸
				if(nextj==M-d || nexti==N-d || nextj==d-1||nexti==-1+d) {
					dir++;
					if(dir==4) break; //한바퀴 돌았네 옆칸이고 뭐고 그만해
					else continue; //바꾼 방향으로 다시 위로 가서 옆칸좌표 다시 계산해라.
				}
				//음.. 옆칸이 가도 되는 칸인바노ㅖ? 옆칸에 있는 값 땡겨오고
				map[nowi][nowj] = map[nexti][nextj];
				nowi=nexti;// 나는 그칸으로 이동
				nowj=nextj;
			}
			map[d+1][d]=tmp;
		}
	}
}
