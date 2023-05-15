package X_XTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSTest {
	static int[][] map; // Map
	static int N;	//N은 정점
	static int M;	//M은 간선
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st =new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to]=map[to][from]=1;
		}
		BFS(0);
	}
	private static void BFS(int idx) {
		
		Queue<Integer> queue = new List<>();
		queue.add(idx);
		
		boolean[] checked = new boolean[N];
		checked[idx]=true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 0; i < ; i++) {
			
			}
		}
	}

}
