package X_BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySortTest {
	
	static int N,M;
	static Node[] adjList;
	static int[] inDegree; //진입차수 관리해야됨
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		
	}
	

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		adjList = new Node[N+1];
		inDegree = new int[N+1];
		int from,to;
		for (int i = 0; i < M; ++i) {
			st =new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		ArrayList<Integer>list = topologySort();
		if(list.size()==N) {
			for(Integer aa: list) {
				System.out.println(aa+" ");
			}
		}else {
			System.out.println("cycle");
		}
	}
	static ArrayList<Integer> topologySort(){
		ArrayList<Integer> orderList = new ArrayList<Integer>();
		Queue<Integer>queue = new ArrayDeque<Integer>();
		for (int i = 1; i <=N; i++) {
			if(inDegree[i]==0) queue.offer(i);
		}//진입차수가 0인정점 큐에 넣기
		while(!queue.isEmpty()) {
			int cur= queue.poll();
			orderList.add(cur);
			
			for(Node temp = adjList[cur]; temp!=null; temp= temp.link) {
				if(--inDegree[temp.vertex]==0) {
					queue.offer(temp.vertex);
				}
			}
		}
		return orderList;
		
	}
}
