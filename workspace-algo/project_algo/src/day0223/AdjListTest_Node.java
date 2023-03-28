package day0223;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjListTest_Node {
	static class Node{
		int vertex;
		Node line;
		public Node(int vertex, Node line) {
			super();
			this.vertex = vertex;
			this.line = line;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", line=" + line + "]";
		}
		
	}
	static Node[] adjList;
	static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		adjList = new Node[V]; //head가 모두 null인 상태
		
		
		int from,to;
		for (int i = 0; i < E; ++i) {
			from = sc.nextInt();
			to = sc.nextInt();
			//무향 그래프
			adjList[from]= new Node(to, adjList[from]);
			adjList[to]= new Node(from, adjList[to]);
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
			for(Node temp = adjList[current]; temp !=null; temp=temp.line) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex]=true;
				}
			}
		}
		
	}
	static void print() {
		for(Node am : adjList) { //node : 각 정점의 인접리스트이 Head
			System.out.println(am);
		}
	}
}
