package X_swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
	static int N;
	static int[][] map;
	static boolean[][] checked;
	static int x;
	static int y;
	static int[] dx= {1,1,-1,-1};
	static int[] dy= {1,-1,-1,1};
	static int move;
	static List<Integer> arr;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new  BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		move=0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		result=0;
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				checked =new boolean[N][N];
				arr=new ArrayList<>();
				x=i;
				y=j;
				DFS(i,j,0);
				//print(checked);
				//System.out.println("=============");
			}
		}
		System.out.println(result);
		
	}
	private static void DFS(int i, int j,int dir) {
		if(i<0 || i==N || j<0 || j==N) {
			return;
		}
		if(checked[i][j]) {
			if(i==x && j==y) {
				System.out.println(arr);
				for (int k = 0; k < arr.size(); k++) {
					for (int k2 = k+1; k2 < arr.size(); k2++) {
						
						if(arr.get(k)==arr.get(k2)) {
							return;
						}
					}
				}
				result++;
				return;
			}
			else {
				return;
			}
		}
		checked[i][j]=true;
		arr.add(map[i][j]);
		//static int[] dx= {1,1,-1,-1};
		//static int[] dy= {1,-1,-1,1};
		//이게 쭉가는거
		int nexti = i+dx[dir];
		int nextj = j+dy[dir];
		DFS(nexti,nextj,dir);
		//꺾기 
		dir++;
		dir%=4;
		nexti = i+dx[dir];
		nextj = j+dy[dir];
		DFS(nexti,nextj,dir);
		checked[i][j]=false;
		arr.remove(arr.size()-1);
		//System.out.println(arr);
		
	}
	private static void print(boolean[][] checked2) {
		for (int i = 0; i < checked2.length; i++) {
			for (int j = 0; j < checked2[i].length; j++) {
				System.out.print(checked2[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
