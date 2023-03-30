package X_Professor.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	static int[][] map ; 
	static int[][] copy;
	static int N;
	boolean isFlag;
	static int[] dx= {0,0,1};
	static int[] dy= {-1,1,0};
	static int dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <=10; tc++) {
			int num = Integer.parseInt(br.readLine());
			map =new int[100][100];
			
			for (int i = 0; i <100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j <100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				if(map[0][i]==1) {
					dir=0;
					copy= ArrayCopy(map);
					copy[0][i]=3;
					int result = start(0,i,dir);
					if(result>0) {
						System.out.println("#"+num+" "+result);
						break;
					}
					
				}
			}
		}
		
		
		
	}
	private static int[][] ArrayCopy(int[][] map) {
		int[][] tmp = new int[100][100];
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				tmp[i][j]=map[i][j];
			}
		}
		return tmp;
		
	}
	
	
	private static int start(int i, int j,int dir) {
		int x = i;
		int y =j;
		boolean isFlag=true; 
		while(true) {
			int nowi = x+dx[dir];
			int nowj = y+dy[dir];
			if(nowi<0 || nowi>=100 || nowj<0 || nowj>=100 || copy[nowi][nowj]==0 || copy[nowi][nowj]==3) {
				dir++;
				dir%=3;
				continue;
			}
			if (copy[nowi][nowj]==2) {
				break;
			}
			if(copy[nowi][nowj]==1) {
				if(x==98) {
					isFlag=false;
					break;
				}
				copy[x][y]=3;
				x=nowi;
				y=nowj;
				dir=0;
				continue;
			}
		}
		if(isFlag) {
			return j;
		}
		else {
			return 0;
		}
		
	}

//	
//	private static void showmap(int[][] tmp) {
//		
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				System.out.print(tmp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		
//	}
//	
//	
}
