package day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static int N;
	static int M;
	static int X;
	static int Y;
	static int drc;
	static int[][] map;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static int dir;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		st =new StringTokenizer(br.readLine());
		X=Integer.parseInt(st.nextToken());
		Y=Integer.parseInt(st.nextToken());
		drc=Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		map[X][Y]=0;
		boolean isFlag=false;
		while(true) {
			for (int i = 0; i < dx.length; i++) {
				for (int j = 0; j < dy.length; j++) {
					if(map[X+dx[drc]][Y+dy[drc]]==0) {
						isFlag=true;
						break;
					}
				}
			}
			if(isFlag) {
				drc-=1;
				if(drc==-1) {
					drc=3;
				}
				if(map[X+dx[drc]][Y+dy[drc]]==0) {
					map[X+dx[drc]][Y+dy[drc]]=3;
					continue;
				}
				else if(map[X+dx[drc]][Y+dy[drc]]==1) { 
					
				}
				notBlank();
				findBlank();
			}//is Flag
		}
		
		
	}
	private static void findBlank() {
		// TODO Auto-generated method stub
		
	}
	private static void notBlank() {
		// TODO Auto-generated method stub
		
	}
	private static void firstClean() {
		// TODO Auto-generated method stub
		
	}
}
