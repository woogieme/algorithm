package day0223;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

import day0223.AdjListTest_Node.Node;

public class AdjListTest_ArrayList {
	static ArrayList<Integer>[] adjList;
	static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		adjList = new ArrayList[V]; //head가 모두 null인 상태
		for (int i = 0; i < V; ++i) { 
			adjList[i]=new ArrayList<Integer>();
		}
		
		int from,to;
		for (int i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			//무향 그래프
			adjList[from].add(to);
			adjList[to].add(from);
		}
		//print();
		BFS(0);
	}
	private static void BFS(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		queue.offer(start);
		visited[start]=true;
		
		int current=0;
		while(queue.size()!=0) {
			current = queue.poll();
			System.out.println((char)(current+65));//탐색할때 해야할일
			for(int vertex : adjList[current]) {
				if(!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex]=true;
				}
			}
		}
		
	}
	static void print() {
		for(ArrayList<Integer> am : adjList) { //node : 각 정점의 인접리스트이 Head
			System.out.println(am);
		}
	}
}
