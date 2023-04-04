package X_Professor.day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9205_맥주마시면서걸어가기 {
	static Point[] points; //출발지, 도착지, N개의 편의점 좌표 객체들
	static int N; //편의점 갯수
	static boolean result; //도착여부
	static boolean[] visit; //특정 정점에 대한 방문체크 여부 
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 0; tc < TC; tc++) {
			N = sc.nextInt();
			
			points = new Point[N+2]; //집 도착지 , N 개의 편의점
			
			for (int i = 0; i <=N+1; i++) {// 0번은 집 1~N까지 편의점 N+1 이 페스티벌
				points[i] = new Point(sc.nextInt(), sc.nextInt());
			}
			visit = new boolean[N+2];
			result = false;
			
			dfs(0); //출발지부터 방문 시작 
			if(result) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
	}
	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(points[0]);
		visit[0]=true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			if(now.x==points[N+1].x && now.y==points[N+1].y){
				result=true;
				return;
			}
			
			for (int next = 1; next <=N+1; next++) {
				int dist = Math.abs(points[next].x - now.x)+ Math.abs(points[next].y - now.y);
				if(dist<=1000 && !visit[next] && !result) {
					queue.add(points[next]);
					visit[next]=true;
				}
			}
			
		}
	}
	
	private static void bfs2() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(points[0]);
		visit[0]=true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			if(now.x==points[N+1].x && now.y==points[N+1].y){
				result=true;
				return;
			}
			
			for (int next = 1; next <=N+1; next++) {
				int dist = Math.abs(points[next].x - now.x)+ Math.abs(points[next].y - now.y);
				if(dist<=1000 && !visit[next] && !result) {
					queue.add(points[next]);
					visit[next]=true;
				}
			}
			
		}
	}
	private static void dfs(int now) { //현재 내가 위치하고있는 정점번호 (출발 0부터 시작됨)
		visit[now]=true;
		if(now==N+1) { //페스티벌 장소에 왔다고 ??!!
			result = true;
			return;
		}
		for (int next = 1; next <=N+1; next++) {
			int dist = Math.abs(points[next].x - points[now].x)+ Math.abs(points[next].y - points[now].y);
			if(dist<=1000 && !visit[next] && !result) {
				dfs(next);
			}
		}
		
		
	}

	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
