package day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {
	static int N;
	static int M;
	static int R;
	static int[][] map;
	static int T;
	static int[][] map_tmp;
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
		st = new StringTokenizer(br.readLine());
		T= Integer.parseInt(st.nextToken());
		for (int i = 0; i <R; i++) {
			switch(T) {
			case 1:
				horizonSwap();
				break;
			case 2:
				perpenSwap();
				break;
			case 3:
				rightRotate();
				break;
			case 4:
				leftRotate();
				break;
			case 5:
				counterClock();
				break;
			case 6:
				clock();
				break;
			}
		}
		
	}
	private static void horizonSwap() {
		int limited= N/2;
		for (int i = 0; i < limited; i++) {
			for (int j = 0; j < M; j++) {
				int tmp=map[i][j];
				map[i][j]=map[N-i-1][j];
				map[N-i-1][j]=tmp;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void perpenSwap() {
		int limited= M/2;
		for (int i = 0; i < limited; i++) {
			for (int j = 0; j < N; j++) {
				int tmp=map[j][i];
				map[j][i]=map[j][M-i-1];
				map[j][M-i-1]=tmp;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void rightRotate() {
		map_tmp=new int[M][N];
		for (int i = 0; i <M; i++) {
			for (int j = 0; j < N; j++) {
				map_tmp[i][j]=map[N-j-1][i];
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map_tmp[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void leftRotate() {
		map_tmp=new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map_tmp[i][j]=map[j][M-i-1];
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map_tmp[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void clock() {
		int[][] arr = new int [N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[i][j]=map[i][j];
			}
			
		}
			for (int x = 0; x < N/2; x++) {
				for (int y = M/2; y <M ; y++) {
					map[x][y-M/2]=map[x][y];
				}
			}
		
			for (int x = N/2; x < N; x++) {
				for (int y = M/2; y <M ; y++) {
					map[x-N/2][y]=map[x][y];
				}
			}
			
			for (int x = N/2; x < N; x++) {
				for (int y = 0; y <M/2; y++) {
					map[x][y+M/2]=map[x][y];
				}
			}
			
			for(int x=N/2; x<N; x++) {
				for (int y = 0; y < M/2; y++) {
					map[x][y]=arr[x-N/2][y];
				}
		}//1 끝 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	private static void counterClock() {
		int[][] arr = new int [N/2][M/2];
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < M/2; j++) {
				arr[i][j]=map[i][j];
			}
			
		}
			for (int x = N/2; x < N; x++) {
				for (int y = 0; y <M/2 ; y++) {
					map[x-N/2][y]=map[x][y];
				}
			}
		
			for (int x = N/2; x < N; x++) {
				for (int y = M/2; y <M ; y++) {
					map[x][y-M/2]=map[x][y];
				}
			}
			
			for (int x = 0; x < N/2; x++) {
				for (int y = M/2; y <M; y++) {
					map[x+N/2][y]=map[x][y];
				}
			}
			
			for(int x=0; x<N/2; x++) {
				for (int y = M/2; y < M; y++) {
					map[x][y]=arr[x][y-M/2];
				}
		}//1 끝 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
	}

}
