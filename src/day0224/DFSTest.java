package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFSTest {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			map[to][from]=map[from][to]=1;
			
		}
		visited = new boolean[N][M];
		DFS(0);
		
	}
	private static void DFS(int idx) {
		visited[idx][idx]=true;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][i]) {
					DFS(i);
				}
			}
		}
		
	}
}
