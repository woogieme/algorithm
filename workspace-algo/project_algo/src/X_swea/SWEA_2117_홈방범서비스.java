package X_swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA_2117_홈방범서비스 {
	static int N;
	static int M;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int iTmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i <N; i++) {
			for (int j = 0; j <N; j++) {
				BFS(i,j);
			}
		}
		System.out.println(iTmp);
		
	}
	private static void BFS(int x, int y) {
		iTmp=Integer.MIN_VALUE;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		boolean[][] checked = new boolean[N][N];
		int count=1;
		map[x][y]=1;
		checked[x][y]=true;
		int result=0;
		
		while(!queue.isEmpty()) {
			int size =queue.size();
			if(count==N/2-1) {
				break;
			}
			for (int i = 0; i < size; i++) {
				Point now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nexti= now.x+dx[d];
					int nextj=now.y+dy[d];
					if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && !checked[nexti][nextj]) {
						checked[nexti][nextj]=true;
						queue.add(new Point(nexti,nextj));
					}
				}
			}
			count++;
			
			int value=0;
			int tmp=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(checked[i][j]&&map[i][j]==1) {
						result++;
						value+=M;
					}
				}
			}
			tmp=count*count+((count-1)*(count-1));
			if((tmp-value)>=0) {
				if(iTmp<result) {
					iTmp=result;
				}
			}
			
		}
		
		
		
	}
	
	private static void print() {
		System.out.println("===============================");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
