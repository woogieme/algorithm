package day0222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjListTest {
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
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
		print();
	}
	static void print() {
		for(ArrayList<Integer> am : adjList) { //node : 각 정점의 인접리스트이 Head
			System.out.println(am);
		}
	}
}
