package X_Professor.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int start;
	static int end;
	static int ans;
	static boolean[] visited;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		visited= new boolean [100001];
		BFS(start);
	}
	private static void BFS(int idx) {
		Queue<Integer> arr = new LinkedList<>();
		arr.add(idx);
		visited[idx]=true;
		while(!arr.isEmpty()) {
			int size =arr.size();
			//System.out.println(value);
			for (int i = 0; i < size; i++) {
				int value = arr.poll();
				if(value==end) {
					System.out.println(cnt);
					break;
				}
				if((value+1)>=0 && (value+1) <=100000 && !visited[value+1]) {
					visited[value+1]=true;
					arr.add(value+1);
				}
				if((value-1)>=0 && (value-1) <=100000 && !visited[value-1]) {
					visited[value-1]=true;
					arr.add(value-1);
				}			
				if((value*2)>=0 && (value*2) <=100000&& !visited[value*2]) {
					visited[value*2]=true;
					arr.add(value*2);
				}
			}
			cnt++;
			
		}
		
	}
}
