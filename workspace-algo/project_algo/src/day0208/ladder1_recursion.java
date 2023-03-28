package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ladder1_recursion {
	static int[][] map;
	static int[] di = {0,0,-1}; //좌, 우 먼저 탐색하고 위로는 마지막에 탐색
	static int[] dj = {-1,+1,0}; 
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC=10;
		for (int tc = 1; tc <= TC; tc++) {
			int ans = -1;
			br.readLine();
			map = new int[100][100];
			
			
			int nowi = 100, nowj=100;
			
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//String[] line = br.readLine().split(" ");
				//Char[] line = br.readLine().charToArray;
				for (int j = 0; j < 100; j++) {
					//map[i][j] = Intger.parseInt(line[j]);
					//map[i][j] = line[j].charAt(0)-'0';
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==2) {
						nowi=i;
						nowj=j;
					}
				}
			}//end for Input
			go(nowi,nowj);
			System.out.println("#"+tc+" "+nowj);
			
		}
	}
	private static void go(int nowi, int nowj) {
		if(nowi==0) {
			ans=nowj;
			return;
		}
		map[nowi][nowj]=-1;
		for(int d=0; d<di.length; d++) { // left , right > up
				int nexti=nowi+di[d];
				int nextj=nowj+dj[d];
				if(nextj>=0 && nextj<100 && map[nexti][nextj]==1) {
					go(nowi,nowj);
				}
			}
			//print();
			
		}//end for Searching
		
	private static void print() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.print(map[i][j]==-1 ? "*":map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
