package X_Professor.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	static int N;
	static int M;
	static int S;
	static int[][] map;
	static int[][] saveMap;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		saveMap=new int[N][M];
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				int sum=0;
				if(map[i][j]>=1) {
					int value= map[i][j]/5;
					for (int d = 0; d < 4; d++) {
						int nexti = i+dx[d];
						int nextj = j+dy[d];
						if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]!=-1) {
							sum+=value;
							saveMap[nexti][nextj]+=value;
						}
					}
					if(map[i][j]==5) {
						System.out.println(sum);
					}
					map[i][j]-=sum;
				}
				
				
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				map[i][j]+=saveMap[i][j];
//			}
//		}
//		
		print(map);
		System.out.println("-----------------");
		print(saveMap);
		
		
		
	}
	private static void print(int[][] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				System.out.print(tmp[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
