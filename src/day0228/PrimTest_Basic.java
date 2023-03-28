package day0228;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimTest_Basic {
	static int V; //정점의 갯수 0~V
	static int[][] adjArr; //인접행렬
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V= sc.nextInt();
		adjArr= new int [V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adjArr[i][j]=sc.nextInt();
			}
		}
		int result=0; //전체 정점을 연결하는 총합 최소비용.
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0,2)); //시작 정점은 누가되든 상관없음. 어차피 모두가 연결될거라서, 처음 영입비는 0원
		boolean[] visit = new boolean[V]; //이미 영입된 정점인지 체크용.
		int count=1; //내가 영입한 정점의 갯수
		while(!pq.isEmpty() && count<V) {
			Edge now = pq.poll(); //방금영입한 성공한 정점 ! pq에서는 현재 제일 영입이용 저렴한 애가 나옴  
			System.out.println(now.num+" : "+now.weight);
			if(visit[now.num]) continue; //간선 누적하다보니 짧긴한데 이미 우리편으로 영입한 얘네? 이간선은 제껴 
			
			visit[now.num]=true; //영입성공
			result+=now.weight; //영입에 들어간 비용 
			
			//자 방금 영입한 애한테 친구를 데려오라고 하자
			for (int v = 0; v < V; v++) {//인접행렬
				if(!visit[v] && adjArr[now.num][v]>0) {//아직 영입하지 않은 친구 있니?
					pq.add(new Edge(adjArr[now.num][v],v));
				}
			}
		}
		System.out.println("전체 연결 "+result);
	}
	static class Edge implements Comparable<Edge>{ //implements한 이유는 제일 작은 간선을 사용하기위해서 비교해줘야함
		int weight,num; //막대사탕처럼 생긴 엣지    -----------O -는 간선 O는 노드
		//weight는 간선[비용]을 의미
		//num은 노드를 의미
		public Edge(int weight, int num) {
			super();
			this.weight = weight;
			this.num = num;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}

}
