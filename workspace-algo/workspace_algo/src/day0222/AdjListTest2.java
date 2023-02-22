package day0222;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjListTest2 {
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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
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
		print();
	}
	static void print() {
		for(Node am : adjList) { //node : 각 정점의 인접리스트이 Head
			System.out.println(am);
		}
	}
}
