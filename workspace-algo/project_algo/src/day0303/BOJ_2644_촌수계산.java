package day0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
	static ArrayList<Integer>[] adjList;
	static int V,E;
	static int find_V,find_E;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		V=Integer.parseInt(br.readLine());
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		find_V=Integer.parseInt(st.nextToken());
		find_E=Integer.parseInt(st.nextToken());
		
		E=Integer.parseInt(br.readLine());
		visited=new boolean[V+1];
		adjList = new ArrayList[V+1]; //head가 모두 null인 상태
		for (int i = 1; i <=V; ++i) { 
			adjList[i]=new ArrayList<Integer>();
		}
		ans=-1;
		for (int i = 0; i < E; i++) {
			st =new StringTokenizer(br.readLine());
			int from =Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		BFS(find_V);
		
	}
	private static void BFS(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V+1];
		
		queue.offer(start);
		visited[start]=true;
		boolean isFlag=false;
		
		int current=0;
		while(!queue.isEmpty()) {
			int size=queue.size();
			ans++;
			for (int i = 0; i <size; i++) {
				current = queue.poll();
				if(current==find_E) {
					isFlag=true;
					break;
				}
				for(int vertex : adjList[current]) {
					if(!visited[vertex]) {
						queue.offer(vertex);
						visited[vertex]=true;
					}
				}
			}
			if(isFlag) {
				break;
			}
			
		}
		if(current==find_E) {
			System.out.println(ans);
		}
		else {
			System.out.println(-1);
		}
		
	}
}