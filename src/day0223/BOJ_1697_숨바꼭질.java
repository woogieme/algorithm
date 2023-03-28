package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int N;
	static int M;
	static int[] map;
	static int count;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		ans=0;
		System.out.println(BFS());	}
	private static int BFS() {
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		queue.offer(N);
		visited[N]=true;
		
		int current=0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				current=queue.poll();
				if(current==M) {
					return ans;
				}
			if(current-1 >=0 && !visited[current-1] ) {
				visited[current-1]=true;
				queue.add(current-1);
			}
			if(current+1 <=100000 && !visited[current+1]) {
				visited[current+1]=true;
				queue.add(current+1);
			}
			if(current*2 <=100000 && !visited[current*2] ) {
				visited[current*2]=true;
				queue.add(current*2);
			}
			}
			ans++;
		}
		return -1;
		
	}
}
