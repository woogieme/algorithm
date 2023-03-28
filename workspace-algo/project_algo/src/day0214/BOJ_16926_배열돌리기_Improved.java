package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기_Improved {
	static int N;
	static int M;
	static int R;
	static int[][] map;
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
	}
	private static void rotate() {
		// TODO Auto-generated method stub
		int depth = Math.min(N, M)/2;
		for (int d = 0; d < depth; d++) {
			int tmp = map[d][d]; //현재 레이어의 좌상 뽑아놓기 ( 퍼즐에 빈칸이 있어야 옆칸을 떙겨오지!!)
			for (int j = d; j < M-d-1; j++) {
				map[d][j]=map[d][j+1];
			}
			for (int i = d; i < N; i++) {
				map[i][M-1-d]=map[i+1][M-1-d];
			}
			for (int j = M-1-d; j >=1+d; j--) {
				map[N-1-d][j]=map[N-1-d][j-1];
			}
			for (int i = N-1-d; i >=1+d; i--) {
				map[i][d]=map[i-1][d];
			}
			map[d+1][d]= tmp;
		}
	}
}
