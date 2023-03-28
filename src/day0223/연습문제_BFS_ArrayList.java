package day0223;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연습문제_BFS_ArrayList {
	static int[][] mapA;
	static int[][] mapB;
	static int N;
	static int M;
	static int idx;
	static LinkedList<Integer>[] adjList;
	static boolean visited[];	
	public static void main(String[] args) {
		N=7;
		Scanner sc = new Scanner(System.in);
		M=sc.nextInt();
		idx = sc.nextInt();
		adjList = new LinkedList[N + 1];

		for (int i = 0; i <= N; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjList[v1].add(v2);
			adjList[v2].add(v1);
		}
		visited = new boolean[N+1];
		System.out.println();
		BFS(idx);
	}

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v]=true;
		
		while(queue.size()!=0) {
			v=queue.poll();
			System.out.println(v+ " ");
			
			for (int i = 0; i < adjList[v].size(); i++) {
				if(!visited[adjList[v].get(i)]) {
					visited[adjList[v].get(i)]=true;
					queue.offer(adjList[v].get(i));
				}
			}
		}
		
	}

}
