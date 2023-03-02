package day0302;

import java.util.PriorityQueue;

public class Dijkstra_PQ {
	static int N;
	static int[][] adjArr;
	public static void main(String[] args) {
		
	}
	static int dijkstra(int start, int end) {
		PriorityQueue<Edge> pq =new PriorityQueue<>();
		boolean[] visit =new boolean[N]; //어떤 정점까지의 최소비용이 나왔는지 기록하는 배열
		pq.add(new Edge(0,start)); //출발점을 영입하는데 드는 비용은 0원
		
		while(!pq.isEmpty()) {
			Edge minEdge = pq.poll(); //현재 확보한 간선중 가장 짧은 간선이 나옴 (끝에 정점 매달려있음)
			if(visit[minEdge.num]) continue; //얘는 최소비용 이미기록되었던 애야(새로운 정점이 아냐)
			
			//오 내가 현재 새로 영입할수있는 애들중엔 가장 저렴하네?!(나머지 막대는 더 길어. 현재 비용이 최저니까 얘 비용 확실 ! 기록 완료!)
			visit[minEdge.num]=true;
			for (int i = 0; i < N; i++) {
				if(!visit[i] && adjArr[minEdge.num][i]>0) {
					pq.add(new Edge(minEdge.weight+adjArr[minEdge.num][i],i));
				}
			}
			
		}
		return -1;
	}
	static class Edge implements  Comparable<Edge>{
		int weight, num;

		public Edge(int weight, int num) {
			super();
			this.weight = weight;
			this.num = num;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
