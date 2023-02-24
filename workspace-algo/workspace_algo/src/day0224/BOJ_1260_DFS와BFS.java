package day0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int N;
	static int M;
	static int current;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		current=Integer.parseInt(st.nextToken());
		
		map=new int[N+1][N+1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			map[to][from]=map[from][to]=1;
		}
		visited=new boolean[N+1];
		DFS(current,visited);
		System.out.println();
		BFS(current);
		
	}
	private static void DFS(int current, boolean[] visit) {
		visit[current]=true;
		System.out.print(current+" ");
		for (int i = 1; i <=N; i++) {
			if(map[current][i]==1&& !visit[i]) {
				DFS(i,visit);
			}
		}
		
	}
	private static void BFS(int current) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(current);
		boolean[] checked = new boolean[N+1];
		checked[current]=true;
		
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.print(current+" ");
			for (int i = 1; i <=N; i++) {
				if(map[current][i]!=0 && !checked[i]) {
					queue.add(i);
					checked[i]=true;
				}
			}
			
		}
		
		
	}

}
