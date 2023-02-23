package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질_Improved_ver2 {
	static int N;
	static int K;//출발,도착
	static int[] map;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		System.out.println(BFS());
		
		}
	private static int BFS() {
		
		Queue<Point> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		queue.offer(new Point(N)); //출발점은 연산횟수 없이 그냥 만들어진 수임.
		int cnt = 0; // 이게 현재 큐에 들어있는 애들을 만들기위한 연산수행 횟수임
		visited[N]=true;	//큐에 넣을때 표시하기.
		while(!queue.isEmpty()) {//방문 스케줄 남은게 있으면 계속하자
			int size = queue.size();
			for (int s = 0; s < size; s++) {
			Point now = queue.poll();
				if(now.num==K) {
					return ans;
				}
				if(now.num-1 >=0 && !visited[now.num-1] ) {
					visited[now.num-1]=true;
					
					queue.add(new Point(now.num-1));
				}
				if(now.num+1 <=100000 && !visited[now.num+1] ) {
					visited[now.num-1]=true;
					
					queue.add(new Point(now.num+1));
				}
				if(now.num*2 <=100000 && !visited[now.num*2] ) {
					visited[now.num*2]=true;
					
					queue.add(new Point(now.num*2));
				}
			}
			ans++;
		}
		return -1;
		
	}
	static class Point{
		int num; //정점, 정점이 만들어지기 위해 사용된 연산횟
		public Point(int num) {
			super();
			this.num = num;
		}
	}
}
